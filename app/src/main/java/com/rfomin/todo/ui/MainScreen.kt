package com.rfomin.todo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(modifier = Modifier.fillMaxSize()) {
                var textFieldValue: TextFieldValue by remember {
                    mutableStateOf(TextFieldValue(text = ""))
                }

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    value = textFieldValue,
                    onValueChange = {
                        textFieldValue = it
                    },
                    label = { Text(text = "Task title...") },
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0, 128, 0)
                    ),
                    onClick = {
                        viewModel.insertTask(textFieldValue.text)
                        textFieldValue = TextFieldValue(text = "")
                    }
                ) {
                    Text(text = "Add")
                }

                Spacer(modifier = Modifier.height(16.dp))

                val dataState = viewModel.allTasks.observeAsState()

                TaskList(
                    items = dataState.value ?: emptyList(),
                    onComplete = {
                        viewModel.completeTask(it)
                    },
                    onDelete = {
                        viewModel.deleteTask(it)
                    }
                )
            }
        }
    }
}




