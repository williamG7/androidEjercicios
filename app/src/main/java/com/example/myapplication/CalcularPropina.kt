package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import com.example.tipcalcular.ui.theme.TipCalculatorTheme

class CalcularPropina(name: String, modifier: Modifier) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorApp()
        }
    }
}

@Composable
fun TipCalculatorApp() {
    var menuPrice by remember { mutableStateOf("") }
    var tipPercentage by remember { mutableStateOf("") }
    var tipAmount by remember { mutableStateOf(0.0) }
    var totalAmount by remember { mutableStateOf(0.0) }

    // Function to calculate the tip
    fun calculateTip() {
        val price = menuPrice.toDoubleOrNull() ?: 0.0
        val percentage = tipPercentage.toDoubleOrNull() ?: 0.0
        tipAmount = price * (percentage / 100)
        totalAmount = price + tipAmount
    }

    TipCalculatorTheme {
        // Layout of the app
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Calculadora de Propina", style = MaterialTheme.typography.h5)

            Spacer(modifier = Modifier.height(16.dp))

            // Menu price input
            TextField(
                value = menuPrice,
                onValueChange = { menuPrice = it },
                label = { Text("Precio del Menú") },
                keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tip percentage input
            TextField(
                value = tipPercentage,
                onValueChange = { tipPercentage = it },
                label = { Text("Porcentaje de Propina") },
                keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button to calculate the tip
            Button(onClick = { calculateTip() }) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Show result
            Text("Propina: %.2f".format(tipAmount), style = MaterialTheme.typography.body1)
            Text("Precio Total: %.2f".format(totalAmount), style = MaterialTheme.typography.body1)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorApp()
}
