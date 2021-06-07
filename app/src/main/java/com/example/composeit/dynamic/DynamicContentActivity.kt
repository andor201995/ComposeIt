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
import androidx.compose.runtime.livedata.observeAsState
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
fun MainScreen(viewModel: DynamicContentViewModel = DynamicContentViewModel()) {
    val newName = viewModel.textFieldState.observeAsState("")
    val nameList = viewModel.greetingListState.observeAsState(listOf())

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            GreetingMessage(
                nameList.value,
                { viewModel.onButtonClicked() },
                newName.value
            ) { viewModel.onTextChanged(it) }
        }
    }
}

@Composable
private fun GreetingMessage(
    nameList: List<String>,
    onButtonClick: () -> Unit,
    newName: String,
    newNameUpdate: (String) -> Unit
) {
    nameList.forEach { Name(it) }

    TextField(value = newName, onValueChange = newNameUpdate)

    Button(onClick = onButtonClick) { Text(text = "Submit") }
}

@Composable
fun Name(name: String) {
    Text(text = "Welcome $name !")
}

@Preview
@Composable
private fun Preview() {
    MainScreen()
}