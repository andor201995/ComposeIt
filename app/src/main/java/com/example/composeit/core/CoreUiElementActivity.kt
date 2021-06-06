package com.example.composeit.core

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CoreUiElementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    Surface(
        shape = RectangleShape,
        color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight()
            ) {
                ColorBar(Color.Magenta)
                ColorBar(Color.White)
            }
            ColorBar(Color.Yellow)
            ColorBar(Color.Blue)
            ColorBar(Color.Cyan)
        }

    }
}

@Composable
private fun ColorBar(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .wrapContentSize(align = Alignment.TopStart)
            .size(70.dp),
    ) {
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MainScreen()
}