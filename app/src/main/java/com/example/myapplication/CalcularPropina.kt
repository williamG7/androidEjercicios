package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign


@Composable
fun CalcularPropina() {
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
                painter = painterResource(id = R.drawable.baja),
                contentDescription = "PIPIPI"
            )
            Text(text = stringResource(R.string.camarero), fontWeight = FontWeight.Bold)
        }
    }
}
