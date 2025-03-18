package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun NumeroSecreto() {
    var boton by remember { mutableStateOf(false) }
    var adivinacion by remember { mutableStateOf("") }
    var numeroSecreto by remember { mutableStateOf(random()) }
    var contador by remember { mutableStateOf(0) }

    Image(
        painter = painterResource(id = R.drawable.ddb93982c3196c10fa92396e3ac7a5b5),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = adivinacion,
            onValueChange = { adivinacion = it },
            label = { Text(text = stringResource(R.string.adivina)) }
        )
        Button(onClick = {
            boton = true
            contador++
        }) {
            Text("Adivina")
        }
        Button(onClick = {
            boton = false
            contador = 0
            numeroSecreto = random()
        }) {
            Text("Reset")
        }

        Text(text = "Intentos: $contador", color = Color.White)

        if (boton) {
            val numeroAdivinado = adivinacion.toIntOrNull()
            if (numeroAdivinado != null) {
                when {
                    numeroAdivinado == numeroSecreto -> {
                        Text(text = stringResource(R.string.igual), color = Color.Green)
                        Image(
                            painter = painterResource(id = R.drawable.victor),
                            contentDescription = "Victoria",
                            modifier = Modifier.size(200.dp)
                        )
                    }

                    numeroAdivinado < numeroSecreto -> {
                        Text(text = stringResource(R.string.mayor), color = Color.White)
                    }

                    else -> {
                        Text(text = stringResource(R.string.menos), color = Color.White)
                    }
                }
            } else {
                Text(text = "Introduce un número válido", color = Color.Red)
            }
        }
    }
}

fun random(): Int {
    var num = Random.nextInt(0, 100)
    return num
}
