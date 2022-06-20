package id.shaderboi.calculator

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import id.shaderboi.calculator.databinding.ActivityMainBinding
import id.shaderboi.calculator.ui.main.view_model.MainEvent
import id.shaderboi.calculator.ui.main.view_model.MainUIEvent
import id.shaderboi.calculator.ui.main.view_model.MainViewModel
import id.shaderboi.calculator.util.Resource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        lifecycleScope.launchWhenCreated {
            launch {
                mainViewModel.mainState.collectLatest { state ->
                    when (val evaluation = state.evaluation) {
                        is Resource.Loaded -> {
                            binding.editTextResult.setText(evaluation.data.toString())
                        }
                        is Resource.Loading -> {
                            binding.editTextResult.setText("Loading...")
                        }
                        is Resource.Error -> {
                            binding.editTextResult.setText("")
                        }
                        null -> {
                            binding.editTextResult.setText("")
                        }
                    }
                }
            }

            launch {
                mainViewModel.mainUIEvent.collectLatest { event ->
                    when (event) {
                        is MainUIEvent.AddText -> binding.editTextEquation.text?.insert(
                            event.position,
                            event.text
                        )
                        is MainUIEvent.Clear -> binding.editTextEquation.text?.clear()
                        is MainUIEvent.Delete -> binding.editTextEquation.text?.delete(
                            (event.position - 1).coerceAtLeast(0), event.position
                        )
                    }
                }
            }
        }

        binding.editTextEquation.doOnTextChanged { text, start, before, count ->
            mainViewModel.onEvent(MainEvent.TextChange(text.toString()))
        }
        binding.editTextEquation.showSoftInputOnFocus = false

        // Numbers
        binding.button0.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("0", binding.editTextEquation.selectionEnd))
        }
        binding.button1.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("1", binding.editTextEquation.selectionEnd))
        }
        binding.button2.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("2", binding.editTextEquation.selectionEnd))
        }
        binding.button3.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("3", binding.editTextEquation.selectionEnd))
        }
        binding.button4.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("4", binding.editTextEquation.selectionEnd))
        }
        binding.button5.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("5", binding.editTextEquation.selectionEnd))
        }
        binding.button6.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("6", binding.editTextEquation.selectionEnd))
        }
        binding.button7.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("7", binding.editTextEquation.selectionEnd))
        }
        binding.button8.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("8", binding.editTextEquation.selectionEnd))
        }
        binding.button9.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddNumber("9", binding.editTextEquation.selectionEnd))
        }
        binding.button00.setOnClickListener {
            mainViewModel.onEvent(
                MainEvent.AddNumber(
                    "00",
                    binding.editTextEquation.selectionEnd
                )
            )
        }
        // Misc
        binding.buttonCE.setOnClickListener {
            mainViewModel.onEvent(MainEvent.Clear)
        }
        binding.buttonDel.setOnClickListener {
            mainViewModel.onEvent(MainEvent.Delete(binding.editTextEquation.selectionEnd))
        }
        binding.buttonEq.setOnClickListener {
            mainViewModel.onEvent(MainEvent.DoCalculation)
        }
        binding.buttonDot.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddDot(binding.editTextEquation.selectionEnd))
        }
        // Op
        binding.buttonAdd.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddOperator("+", binding.editTextEquation.selectionEnd))
        }
        binding.buttonSub.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddOperator("-", binding.editTextEquation.selectionEnd))
        }
        binding.buttonMul.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddOperator("*", binding.editTextEquation.selectionEnd))
        }
        binding.buttonDiv.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddOperator("/", binding.editTextEquation.selectionEnd))
        }
        binding.buttonMod.setOnClickListener {
            mainViewModel.onEvent(MainEvent.AddOperator("%", binding.editTextEquation.selectionEnd))
        }
    }
}