package id.shaderboi.calculator.ui.main.view_model

sealed class MainEvent {
    class TextChange(val text: String): MainEvent()
    class AddNumber(val number: String, val position: Int): MainEvent()
    class AddOperator(val operator: String, val position: Int): MainEvent()
    class AddDot(val position: Int): MainEvent()
    object Clear: MainEvent()
    object DoCalculation: MainEvent()
    class Delete(val position: Int): MainEvent()
}