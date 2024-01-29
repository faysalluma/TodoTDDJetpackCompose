package com.groupec.todotddjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.groupec.todotddjetpackcompose.ui.theme.TodoTDDJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<TodoViewModel>()

        setContent {
            TodoTDDJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   TodoList(viewModel)
                }
            }
        }
    }
}

@Composable
fun TodoList(viewModel: TodoViewModel) {
    val tasks by viewModel.tasks.collectAsState()
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "TODOs", fontSize = 22.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        TaskView(tasks = tasks )
    }
}

@Composable
fun TaskView(tasks: List<Task>) {
    tasks.forEach {
        Text(
            text = it.title, fontSize = 22.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTDDJetpackComposeTheme {
        // TodoList()
    }
}