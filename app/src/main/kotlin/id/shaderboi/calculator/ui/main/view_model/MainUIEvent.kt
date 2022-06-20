package id.shaderboi.calculator.ui.main.view_model

sealed class MainUIEvent {
    class AddText(val position: Int, val text: String): MainUIEvent()
    object Clear: MainUIEvent()
    class Delete(val position: Int): MainUIEvent()
}