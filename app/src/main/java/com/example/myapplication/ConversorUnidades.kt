package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConversionesUnidades() {
    var boton by remember { mutableStateOf(false) }
    var numero by remember { mutableStateOf("") }
    var textoSelecionado by remember { mutableStateOf("") }
    var expandir by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("") }
    val convertir = listOf(
        "De pulgada a cm",
        "De yarda a m",
        "De millas a Km",
        "De cm a pulgada",
        "De m a yarda",
        "De Km a milla"
    )
    Image(
        painter = painterResource(id = R.drawable.ddb93982c3196c10fa92396e3ac7a5b5),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Calculadora para convertir",
            Modifier.padding(40.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.White
        )
    }
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = numero,
            onValueChange = { numero = it },
            label = { Text(text = stringResource(R.string.convertirr)) }
        )
        OutlinedTextField(
            value = textoSelecionado,
            onValueChange = { textoSelecionado = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expandir = true }
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Red,
                unfocusedIndicatorColor = Color.Gray
            )
        )
        DropdownMenu(
            expanded = expandir,
            onDismissRequest = { expandir = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            convertir.forEach { convertir ->
                DropdownMenuItem(text = { Text(text = convertir) }, onClick = {
                    textoSelecionado = convertir
                    expandir = false
                })
            }
        }
        Button(onClick = {
            val valor = numero.toDoubleOrNull()
            resultado = if (valor != null) {
                when (textoSelecionado) {
                    "De pulgada a cm" -> "${pulgada_cm(valor)} cm"
                    "De yarda a m" -> "${yarda_m(valor)} m"
                    "De millas a Km" -> "${millas_km(valor)} Km"
                    "De cm a pulgada" -> "${cm_pulgada(valor)} pulgadas"
                    "De m a yarda" -> "${m_yarda(valor)} yardas"
                    "De Km a milla" -> "${km_milla(valor)} millas"
                    else -> "Selecciona una opción"
                }
            } else {
                "Número inválido"
            }
            boton = true
        }) {
            Text("Calcular")
        }

        if (boton) {
            Text(text = "Resultado: $resultado", fontSize = 20.sp, color = Color.White)
        }
    }
}

fun km_milla(valor: Double): Double {
    return valor / 1.60934
}

fun m_yarda(valor: Double): Double {
    return valor / 0.9144
}

fun cm_pulgada(valor: Double): Double {
    return valor / 2.54
}

fun millas_km(valor: Double): Double {
    return valor * 1.60934
}

fun pulgada_cm(valor: Double): Double {
    return valor * 2.54
}

fun yarda_m(valor: Double): Double {
    return valor * 0.9144
}





