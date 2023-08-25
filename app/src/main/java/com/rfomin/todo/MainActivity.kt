package com.rfomin.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.rfomin.todo.navigation.mainGraph
import com.rfomin.todo.navigation.mainGraphRoute
import com.rfomin.todo.ui.theme.TodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                NavHost(
                    navController = rememberNavController(),
                    startDestination = mainGraphRoute,
                ) {
                    mainGraph()
                }
            }
        }
    }
}
