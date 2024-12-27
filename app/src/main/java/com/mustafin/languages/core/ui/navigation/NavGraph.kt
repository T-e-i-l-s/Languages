package com.mustafin.languages.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

/* Экраны приложения */
@Serializable
object HomeScreen

/* Основной граф навигации приложения */
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen) {}
}