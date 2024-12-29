package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views.lessonQuizUnitView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mustafin.languages.core.utils.lessonUtils.QuizUnitModel
import com.mustafin.languages.core.utils.quizUtils.AnswerStatus

/* View ступени урока с тестом */
@Composable
fun LessonQuizUnitView(
    content: QuizUnitModel,
    viewModel: LessonQuizUnitViewModel = viewModel(),
    onAnswer: (Boolean, () -> Unit) -> Unit
) {
    val selectedAnswerIndex = viewModel.selectedAnswerIndex.collectAsStateWithLifecycle()

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
                AnswerVariantView(
                    text = variant,
                    status = when {
                        selectedAnswerIndex.value == null -> AnswerStatus.DEFAULT_UNCHECKED
                        index == content.correctVariantIndex -> AnswerStatus.CORRECT
                        index == selectedAnswerIndex.value -> AnswerStatus.INCORRECT
                        else -> AnswerStatus.DEFAULT_CHECKED
                    }
                ) {
                    if (selectedAnswerIndex.value != null) return@AnswerVariantView
                    viewModel.selectAnswer(index)
                    onAnswer(index == content.correctVariantIndex) {
                        viewModel.selectAnswer(null)
                    }
                }
            }
        }
    }
}