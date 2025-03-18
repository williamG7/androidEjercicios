package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun DiceImage(dice: Int, onClick: () -> Unit) {
    val diceImage = when (dice) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Image(
        painter = painterResource(id = diceImage),
        contentDescription = "Dado $dice",
        modifier = Modifier
            .size(200.dp)
            .clickable { onClick() }
    )
}

@Composable
fun DiceRollerApp() {
    var dice1 by remember { mutableStateOf(1) }
    var dice2 by remember { mutableStateOf(1) }
    val context = LocalContext.current
    Image(
        painter = painterResource(id = R.drawable.tapestry),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.title),
            contentDescription = "titulo",
            modifier = Modifier.fillMaxWidth().size(400.dp)
        )

        Button(onClick = {
            dice1 = Random.nextInt(1, 7)
            dice2 = Random.nextInt(1, 7)

            if (dice1 == 6 && dice2 == 6) {
                Toast.makeText(context, "JACKPOT!", Toast.LENGTH_SHORT).show()
            }
        }, colors = buttonColors(containerColor = Color.Red)) {
            Text("ROLL THE DICE")
        }

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DiceImage(dice = dice1) { dice1 = Random.nextInt(1, 7) }
            DiceImage(dice = dice2) { dice2 = Random.nextInt(1, 7) }
        }

    }
}