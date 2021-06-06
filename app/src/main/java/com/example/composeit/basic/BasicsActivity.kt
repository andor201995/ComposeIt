package com.example.composeit.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeit.ui.theme.ComposeItTheme

class ßMainActivity : ComponentActivity() {
    @ExperimentalComposeApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("Android")
        }
    }
}

@ExperimentalComposeApi
@Composable
private fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier
            .width(100.dp)
            .height(200.dp)
            .clickable { }
            .padding(20.dp),
        style = MaterialTheme.typography.caption.copy(color = Color.Blue),
        fontWeight = FontWeight.SemiBold
    )
}

@ExperimentalComposeApi
@Preview(showBackground = true)
@Composable
private fun Preview() {
    Greeting("Android")
}