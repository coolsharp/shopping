package com.coolsharp.shopping

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coolsharp.shopping.ui.Calculator
import com.coolsharp.shopping.ui.CalculatorActions
import com.coolsharp.shopping.ui.ProfileScreen
import com.coolsharp.shopping.viewmodel.CalculatorViewModel
import com.coolsharp.shopping.ui.theme.ShoppingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingTheme {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun DemoScreen(modifier: Modifier) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text("text test test  tteset tetset tsetsets")
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    DemoScreen(modifier = Modifier)
}