package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import java.util.Calendar

// Ejercicio 2: Cálculo IMC Crea una app que simule a un entrenador personal.
//El programa pedirá al usuario los siguientes datos: Nombre del usuario Año de nacimiento.
//Altura. Peso. Habrá un botón que, al ser pulsado, realizará unos cálculos y mostrará lo siguiente:
//Nombre del usuario y edad, calculada restando el año actual del año de nacimiento. El IMC (peso/altura2).
//Además, en función del valor del IMC, se mostrará si el usuario tiene peso insuficiente
//(IMC<18,5), normal (18,5>IMC<24,9), sobrepeso (25<IMC<50) u obesidad (50<IMC)


class calcularIMC(): ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            calculadoraIMC()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun calculadoraIMC(){
    var nombreUsuario by remember{ mutableStateOf("") }
    var anyoNacimiento by remember{ mutableStateOf("") }
    var altura  by remember { mutableStateOf("") }
    var peso by remember{ mutableStateOf("") }


    TextField(
        value = nombreUsuario,
        onValueChange = { nombreUsuario = it },
        label = {Text("Nombre del usuario") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

    TextField(
        value = anyoNacimiento,
        onValueChange = { anyoNacimiento = it },
        label = {Text("Año de nacimiento") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )

    TextField(
        value = altura,
        onValueChange = { altura = it },
        label = { Text("Altura en metros") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        modifier = Modifier.fillMaxWidth()
    )

    TextField(
        value = peso,
        onValueChange = { peso = it },
        label = {Text("Peso en kg ") },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        modifier = Modifier.fillMaxWidth()
    )

    Button(onClick = {
        val nombre = nombreUsuario
        val anyo = anyoNacimiento.toIntOrNull()
        val alturaMetros = altura.toDoubleOrNull()
        val pesoKg = peso.toDoubleOrNull()

        val edad = Calendar.getInstance().get(Calendar.YEAR) - anyo!!
        val imc = pesoKg!! / (alturaMetros!! * alturaMetros)

        val categoriaIMC = when{
            imc < 18.5 -> "Peso insuficiente"
            imc in 18.5..24.9 -> "Peso normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }



    }) {
        Text("Calcular")
    }

}