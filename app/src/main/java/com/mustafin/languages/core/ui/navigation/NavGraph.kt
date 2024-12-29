package com.mustafin.languages.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mustafin.languages.mainFlow.ui.screens.homeScreen.HomeScreen
import kotlinx.serialization.Serializable

/* Экраны приложения */
@Serializable object HomeScreen
@Serializable data class LessonScreen(val lessonId: Int)

/* Основной граф навигации приложения */
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreen()
        }

        composable<LessonScreen> {
            val lessonId = it.toRoute<LessonScreen>()
        }
    }
}