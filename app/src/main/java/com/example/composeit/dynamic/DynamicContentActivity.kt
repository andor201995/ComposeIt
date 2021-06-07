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
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class DynamicContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val nameList = remember {
        mutableStateListOf(
            "Anmol",
            "John",
            "Avi",
            "Kajol",
            "Akila",
            "Ammu"
        )
    }
    val newName = remember { mutableStateOf("New Name") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NameList(
                nameList,
                { nameList.add(newName.value) },
                newName.value,
                { newName.value = it })
        }
    }
}

@Composable
private fun NameList(
    names: List<String>,
    bottomClick: () -> Unit,
    newName: String,
    newNameUpdate: (String) -> Unit
) {
    names.forEach { Name(it) }

    TextField(value = newName, onValueChange = newNameUpdate)

    Button(onClick = bottomClick) { Text(text = "Add new Greeting") }
}

@Composable
fun Name(name: String) {
    Text(text = "Welcome $name")
}

@Preview
@Composable
private fun Preview() {
    MainScreen()
}