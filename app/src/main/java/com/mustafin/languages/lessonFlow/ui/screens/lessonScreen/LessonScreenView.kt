package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mustafin.languages.R
import com.mustafin.languages.core.utils.lessonUtils.InformationUnitModel
import com.mustafin.languages.core.utils.lessonUtils.LessonUnitType
import com.mustafin.languages.core.utils.lessonUtils.QuizUnitModel
import com.mustafin.languages.core.utils.quizUtils.AnswerStatus
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
    val contentVisible = viewModel.contentVisible.collectAsStateWithLifecycle()
    val quizAnswerStatus = viewModel.quizAnswerStatus.collectAsStateWithLifecycle()

    // Цвета для градиента в фоне
    val greenColor = colorResource(id = R.color.green)
    val redColor = colorResource(id = R.color.red)
    val additionalColor = colorResource(id = R.color.additional)

    // Настройки анимации цвета градиента
    val gradientColorValue by remember(quizAnswerStatus.value) {
        when (quizAnswerStatus.value) {
            AnswerStatus.CORRECT -> mutableStateOf(greenColor)
            AnswerStatus.INCORRECT -> mutableStateOf(redColor)
            else -> mutableStateOf(additionalColor)
        }
    }
    val gradientColor by animateColorAsState(
        targetValue = gradientColorValue,
        animationSpec = tween(600),
        label = ""
    )

    // Градиент для фона экрана
    val gradient = Brush.verticalGradient(
        listOf(
            gradientColor.copy(alpha = 0.7f),
            colorResource(id = R.color.background)
        ),
        startY = -5000f
    )

    LaunchedEffect(Unit) {
        viewModel.loadLessonData(lessonId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(12.dp)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        lesson.value?.let { lesson ->
            val unit = lesson.stages[currentUnitIndex.value]

            AnimatedVisibility(
                visible = contentVisible.value,
                enter = fadeIn(tween(1000)),
                exit = fadeOut(tween(500)),
            ) {
                key(currentUnitIndex.value) {
                    when (unit.type) {
                        LessonUnitType.INFORMATION -> {
                            val unitContent = (unit.content as InformationUnitModel)
                            LessonInformationUnitView(
                                content = unitContent,
                                onButtonClick = { viewModel.openNextUnit(navController) }
                            )
                        }

                        LessonUnitType.QUIZ -> {
                            val unitContent = (unit.content as QuizUnitModel)
                            LessonQuizUnitView(
                                content = unitContent,
                                onAnswer = { selectedIndex ->
                                    viewModel.onQuizAnswered(
                                        navController,
                                        unitContent.correctVariantIndex == selectedIndex,
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}