package com.example.whatclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatclone.ui.theme.WhatCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Hallo Jens")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
var number:Int by remember { mutableStateOf(0) }
    Column() {
    Button(onClick = { number += 1 }) {
    Text(text = "+1")
}
Text(number.toString())
}

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WhatCloneTheme {
        Greeting("Android")
    }
}