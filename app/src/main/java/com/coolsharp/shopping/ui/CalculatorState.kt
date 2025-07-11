package com.coolsharp.shopping.ui

data class CalculatorState(
    val result: String = "",
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)
