package com.mustafin.languages.mainFlow.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
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
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.statusBarsPadding())

            Text(
                text = stringResource(id = R.string.select_language),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(horizontal = 12.dp),
                color = colorResource(id = R.color.content)
            )

            Spacer(modifier = Modifier.height(12.dp))

            selectedLanguageId?.let { langId ->
                LanguageSelectorView(
                    selectedLanguageId = langId,
                    onSelectLanguage = viewModel::updateSessionLanguage
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(id = R.string.lessons),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 12.dp),
                color = colorResource(id = R.color.content)
            )
        }

        items(lessons) { lesson ->
            Box(Modifier.padding(horizontal = 12.dp)) {
                LessonView(lesson = lesson) { lessonId ->
                    navController.navigate(LessonScreen(lessonId))
                }
            }
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}