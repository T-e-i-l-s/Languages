package com.mustafin.languages.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mustafin.languages.lessonFlow.ui.screens.lessonCompletedScreen.LessonCompletedScreenView
import com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.LessonScreenView
import com.mustafin.languages.mainFlow.ui.screens.homeScreen.HomeScreenView
import kotlinx.serialization.Serializable

/* Экраны приложения */
@Serializable object HomeScreen
@Serializable data class LessonScreen(val lessonId: Int)
@Serializable object LessonCompletedScreen

/* Основной граф навигации приложения */
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreenView(navController)
        }

        composable<LessonScreen> {
            val args = it.toRoute<LessonScreen>()
            LessonScreenView(navController = navController, lessonId = args.lessonId)
        }

        composable<LessonCompletedScreen> {
            LessonCompletedScreenView(navController)
        }
    }
}