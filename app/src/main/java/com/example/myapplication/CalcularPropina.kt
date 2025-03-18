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
           // Text("Calculadora de Propina", style = MaterialTheme.typography.h5)

            Spacer(modifier = Modifier.height(16.dp))

            // Menu price input
           // TextField(
            //    value = menuPrice,
             //   onValueChange = { menuPrice = it },
              //  label = { Text("Precio del Menú") },
                //keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
            //        keyboardType = KeyboardType.Number
              //  ),
                //modifier = Modifier.fillMaxWidth()
          //  )

            Spacer(modifier = Modifier.height(16.dp))

            // Tip percentage input
           // TextField(
            //    value = tipPercentage,
            //    onValueChange = { tipPercentage = it },
              //  label = { Text("Porcentaje de Propina") },
              //  keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
            //        keyboardType = KeyboardType.Number
              //  ),
               // modifier = Modifier.fillMaxWidth()
           // )

            Spacer(modifier = Modifier.height(16.dp))

            // Button to calculate the tip
            Button(onClick = { calculateTip() }) {
                Text("Calcular")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Show result
           // Text("Propina: %.2f".format(tipAmount), style = MaterialTheme.typography.body1)
           // Text("Precio Total: %.2f".format(totalAmount), style = MaterialTheme.typography.body1)
        }
    }
}

@Composable
fun TipCalculatorTheme(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
   // TipCalculatorApp()
}



@Composable
fun Calcular() {
    var total: String by remember { mutableStateOf("") }
    var porcentaje: String by remember { mutableStateOf("") }
    var calcula: Boolean by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        TextField(
            value = total,
            onValueChange = { total = it },
            label = { Text(text = stringResource(R.string.total)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = porcentaje,
            onValueChange = { porcentaje = it },
            label = { Text(text = stringResource(R.string.porcentaje)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { calcula = true }) {
            Text("Calcular")
        }
        if (calcula) {
            Text(
                text = stringResource(R.string.texto1) + total.toDouble() * (porcentaje.toDouble() / 100),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.montoTotal) + (total.toDouble() * (porcentaje.toDouble() / 100) + total.toDouble()),
                textAlign = TextAlign.Center
            )
        }
        if (calcula && porcentaje == "100") {
            Image(
                painter = painterResource(id = R.drawable.baixa),
                contentDescription = "PIPIPI"
            )
            Text(text = stringResource(R.string.camarero), fontWeight = FontWeight.Bold)
        }
    }
}
