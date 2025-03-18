package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid.Companion.random

@OptIn(ExperimentalUuidApi::class)
@Composable
fun LlimonadaApp() {
    var fase by remember { mutableStateOf(1) }
    var clicsNecessaris: Int by remember { mutableStateOf(random()) }
    var clicsActuals by remember { mutableStateOf(0) }

    val (text, imatge) = when (fase) {
        1 -> Pair("Agafa una llimona", R.drawable.limonero)
        2 -> Pair("Esprem la llimona", R.drawable.limon)
        3 -> Pair("Beu-te-la", R.drawable.limonadas)
        else -> Pair("Comenzar de nuevo ", R.drawable.baso)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text, fontSize = 24.sp, modifier = Modifier.padding(16.dp))

        Image(
            painter = painterResource(id = imatge),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clickable {
                    when (fase) {
                        1 -> fase = 2
                        2 -> {
                            clicsActuals++
                            if (clicsActuals >= clicsNecessaris) {
                                fase = 3
                                clicsActuals = 0
                            }
                        }

                        3 -> fase = 4
                        4 -> {
                            fase = 1
                            clicsNecessaris = Random.nextInt(2, 5)
                        }
                    }
                }
        )
    }
}