package com.coolsharp.shopping.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coolsharp.shopping.ui.theme.Purple40
import com.coolsharp.shopping.ui.theme.Purple80
import com.coolsharp.shopping.ui.theme.PurpleGrey40
import com.coolsharp.shopping.ui.theme.PurpleGrey80

// Button symbols as constants
private const val AC = "AC"
private const val DEL = "Del"
private const val DIVIDE = "/"
private const val MULTIPLY = "x"
private const val SUBTRACT = "-"
private const val ADD = "+"
private const val EQUAL = "="
private const val DECIMAL = "."

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            // Display
            Text(
                text = "${state.number1} ${state.operation?.symbol ?: ""} ${state.number2}".trim(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                style = TextStyle(
                    fontSize = 60.sp,
                    lineHeight = 72.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black,
                    textAlign = TextAlign.End
                ),
                maxLines = 2
            )

            // Button rows
            listOf(
                listOf(AC, DEL, DIVIDE) to listOf(Purple40, Purple40, PurpleGrey80),
                listOf("7", "8", "9", MULTIPLY) to listOf(PurpleGrey40, PurpleGrey40, PurpleGrey40, PurpleGrey80),
                listOf("4", "5", "6", SUBTRACT) to listOf(PurpleGrey40, PurpleGrey40, PurpleGrey40, PurpleGrey80),
                listOf("1", "2", "3", ADD) to listOf(PurpleGrey40, PurpleGrey40, PurpleGrey40, PurpleGrey80),
                listOf("0", DECIMAL, EQUAL) to listOf(PurpleGrey40, PurpleGrey40, Purple80)
            ).forEach { (symbols, colors) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    symbols.forEachIndexed { index, symbol ->
                        val buttonWeight = when (symbol) {
                            AC, "0" -> 2f
                            else -> 1f
                        }

                        CalcuratorButton(
                            symbol = symbol,
                            modifier = Modifier
                                .aspectRatio(buttonWeight)
                                .weight(buttonWeight)
                                .background(colors[index]),
                            onClick = { handleButtonClick(symbol, onAction) }
                        )
                    }
                }
            }
        }
    }
}

private fun handleButtonClick(symbol: String, onAction: (CalculatorActions) -> Unit) {
    when (symbol) {
        AC -> onAction(CalculatorActions.Clear)
        DEL -> onAction(CalculatorActions.Delete)
        DIVIDE -> onAction(CalculatorActions.Operation(CalculatorOperation.Divide))
        MULTIPLY -> onAction(CalculatorActions.Operation(CalculatorOperation.Multiply))
        SUBTRACT -> onAction(CalculatorActions.Operation(CalculatorOperation.Subtract))
        ADD -> onAction(CalculatorActions.Operation(CalculatorOperation.Add))
        EQUAL -> onAction(CalculatorActions.Calculate)
        DECIMAL -> onAction(CalculatorActions.Decimal)
        else -> if (symbol.all { it.isDigit() }) onAction(CalculatorActions.Number(symbol.toInt()))
    }
}