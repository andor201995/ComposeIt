package com.example.composeit.dynamic

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val nameList: ArrayList<String> = arrayListOf(
    "Anmol",
    "John",
    "Avi",
    "Kajol",
    "Akila",
    "Ammu"
)

class DynamicContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameList(names = nameList)
        }
    }
}

@Composable
fun NameList(names: List<String>) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            names.forEach {
                Name(it)
            }
            Button(onClick = {
                nameList.add("Andor")
            }) {
                Text(text = "Add new Greeting")
            }
        }
    }
}

@Composable
fun Name(name: String) {
    Text(text = "Welcome $name")
}

@Preview
@Composable
private fun Preview() {
    NameList(names = nameList)
}