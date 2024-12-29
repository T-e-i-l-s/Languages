package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mustafin.languages.R
import com.mustafin.languages.core.ui.customComponents.buttons.CustomButton
import com.mustafin.languages.core.ui.navigation.HomeScreen
import com.mustafin.languages.core.utils.lessonUtils.InformationUnitModel
import com.mustafin.languages.core.utils.lessonUtils.LessonUnitType
import com.mustafin.languages.core.utils.lessonUtils.QuizUnitModel
import com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views.LessonInformationUnitView
import com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views.lessonQuizUnitView.LessonQuizUnitView

/* Экран прохождения урока */
@Composable
fun LessonScreenView(
    navController: NavController,
    lessonId: Int,
    viewModel: LessonScreenViewModel = hiltViewModel()
) {
    val lesson = viewModel.lesson.collectAsStateWithLifecycle()
    val currentUnitIndex = viewModel.currentUnitIndex.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadLessonData(lessonId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
            .padding(12.dp)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        lesson.value?.let {
            val stage = it.stages[currentUnitIndex.value]

            when (stage.type) {
                LessonUnitType.INFORMATION -> {
                    val unitContent = (stage.content as InformationUnitModel)
                    LessonInformationUnitView(
                        content = unitContent,
                        onButtonClick = { viewModel.openNextUnit(navController) }
                    )
                }

                LessonUnitType.QUIZ -> {
                    val unitContent = (stage.content as QuizUnitModel)
                    LessonQuizUnitView(
                        content = unitContent,
                        onAnswer = { viewModel.openNextUnit(navController) }
                    )
                }
            }
        }
    }
}