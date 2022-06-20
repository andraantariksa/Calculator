package id.shaderboi.calculator.ui.main.view_model

import id.shaderboi.calculator.util.Resource
import java.math.BigDecimal

data class MainState(val equation: CharSequence, val readOnly: Boolean, val evaluation: Resource<BigDecimal>?)