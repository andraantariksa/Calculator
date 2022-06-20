package id.shaderboi.calculator.ui.main.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _mainState = MutableStateFlow(
        MainState(
            equation = ""
        )
    )
    val mainState = _mainState.asStateFlow()
}