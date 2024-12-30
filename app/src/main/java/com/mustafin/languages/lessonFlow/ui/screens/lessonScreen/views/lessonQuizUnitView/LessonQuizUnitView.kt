package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views.lessonQuizUnitView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mustafin.languages.core.utils.lessonUtils.QuizUnitModel
import com.mustafin.languages.core.utils.quizUtils.AnswerVariantViewStatus

/* View ступени урока с тестом */
@Composable
fun LessonQuizUnitView(
    content: QuizUnitModel,
    viewModel: LessonQuizUnitViewModel = viewModel(),
    onAnswer: (Int) -> Unit
) {
    val selectedAnswerIndex = viewModel.selectedAnswerIndex.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.resetState()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Text(
                text = content.question,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Center),
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            content.variants.forEachIndexed { index, variant ->
                val answerStatus = when {
                    selectedAnswerIndex.value == null -> AnswerVariantViewStatus.DEFAULT_UNCHECKED
                    index == content.correctVariantIndex -> AnswerVariantViewStatus.CORRECT
                    index == selectedAnswerIndex.value -> AnswerVariantViewStatus.INCORRECT
                    else -> AnswerVariantViewStatus.DEFAULT_CHECKED
                }

                AnswerVariantView(
                    text = variant,
                    status = answerStatus
                ) {
                    viewModel.onSelectAnswerClick(index)
                    onAnswer(index)
                }
            }
        }
    }
}