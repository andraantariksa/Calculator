package id.shaderboi.calculator.ui.main.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.shaderboi.calculator.util.Resource
import id.shaderboi.calculator.util.calculator.Calculator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    private val calculator = Calculator()

    private val _mainState = MutableStateFlow(
        MainState(
            equation = "",
            readOnly = false,
            evaluation = null
        )
    )
    val mainState = _mainState.asStateFlow()

    private val _mainUIEvent = MutableSharedFlow<MainUIEvent>()
    val mainUIEvent = _mainUIEvent.asSharedFlow()

    private fun addToEquation(position: Int, thing: String) = viewModelScope.launch {
        _mainUIEvent.emit(MainUIEvent.AddText(position, thing))
    }

    private fun onTextChange(newText: String) {
        _mainState.value = _mainState.value.copy(equation = newText)
        doEvaluation()
    }

    private fun clear() = viewModelScope.launch {
        _mainUIEvent.emit(MainUIEvent.Clear)
    }

    private fun delete(position: Int) = viewModelScope.launch {
        _mainUIEvent.emit(MainUIEvent.Delete(position))
    }

    private fun doCalculation() {
        val state = _mainState.value
        _mainState.value = state.copy(evaluation = Resource.Loading())
        val result = calculator.calculate(state.equation.toString())
        _mainState.value =
            state.copy(equation = result.toString(), evaluation = Resource.Loaded(result))
    }

    private fun doEvaluation() {
        val state = _mainState.value
        if (state.equation.isBlank()) {
            _mainState.value = state.copy(evaluation = null)
            return
        }
        _mainState.value = state.copy(evaluation = Resource.Loading())
        try {
            val result = calculator.calculate(state.equation.toString())
            _mainState.value = state.copy(evaluation = Resource.Loaded(result))
        } catch (ex: Exception) {
            _mainState.value = state.copy(evaluation = Resource.Error(ex))
        }
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.AddNumber -> addToEquation(event.position, event.number)
            MainEvent.Clear -> clear()
            is MainEvent.TextChange -> onTextChange(event.text)
            is MainEvent.Delete -> delete(event.position)
            is MainEvent.AddDot -> addToEquation(event.position, ".")
            is MainEvent.AddOperator -> addToEquation(event.position, event.operator)
            MainEvent.DoCalculation -> doCalculation()
        }
    }
}