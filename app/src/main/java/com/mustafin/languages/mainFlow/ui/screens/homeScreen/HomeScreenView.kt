package com.mustafin.languages.mainFlow.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mustafin.languages.R
import com.mustafin.languages.core.ui.navigation.LessonScreen
import com.mustafin.languages.mainFlow.ui.screens.homeScreen.views.LessonView
import com.mustafin.languages.mainFlow.ui.screens.homeScreen.views.languageSelector.LanguageSelectorView

/* Главный экран приложения */
@Composable
fun HomeScreenView(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val selectedLanguageId by viewModel.selectedLanguageId.collectAsStateWithLifecycle()
    val lessons by viewModel.lessons.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.statusBarsPadding())

            selectedLanguageId?.let { langId ->
                LanguageSelectorView(
                    selectedLanguageId = langId,
                    onSelectLanguage = viewModel::updateSessionLanguage
                )
            }
        }

        items(lessons) { lesson ->
            LessonView(lesson = lesson) { lessonId ->
                navController.navigate(LessonScreen(lessonId))
            }
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}