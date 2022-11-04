package com.example.whatclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatclone.ui.theme.WhatCloneTheme
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Hallo Jens")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var number: Int by remember { mutableStateOf(0) }
    var startTime: LocalDateTime? by remember { mutableStateOf(null) }
    var remainingTimeText: String by remember {
        mutableStateOf("")

    }

    Column() {
        Row {
            Button(onClick = {
                number += 1
                if (startTime == null) startTime = LocalDateTime.now()
                remainingTimeText = "${calculateRemainingTime(t1 = startTime)}s "
            }) {
                Text(text = "+1")
            }
            Text(text = remainingTimeText)
        }

        Text(number.toString())
        Text(text = "cps : 10,58/s")
        Button(onClick = {
            number = 0
            startTime = null
            remainingTimeText = "0s"
        }) {
            Text(text = "reset")

        }
    }

}

fun calculateRemainingTime(t1: LocalDateTime?): Long {
    if (t1 == null) return -1
    return ChronoUnit.SECONDS.between(t1, LocalDateTime.now())

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhatCloneTheme {
        Greeting("Android")
    }
}