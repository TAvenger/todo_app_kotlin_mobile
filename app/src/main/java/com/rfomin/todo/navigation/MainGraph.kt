package com.rfomin.todo.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rfomin.todo.ui.MainScreen

const val mainGraphRoute = "main_graph_route"
const val mainScreenRoute = "main_screen_route"

fun NavGraphBuilder.mainGraph() = navigation(
    route = mainGraphRoute,
    startDestination = mainScreenRoute
) {
    composable(
        route = mainScreenRoute,
        content = { MainScreen() }
    )
}