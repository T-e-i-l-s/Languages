package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views.lessonQuizUnitView

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.mustafin.languages.R
import com.mustafin.languages.core.utils.quizUtils.AnswerVariantViewStatus

/* View кнопки с вариантом ответа */
@Composable
fun AnswerVariantView(
    text: String,
    status: AnswerVariantViewStatus,
    onClick: () -> Unit
) {
    // Настраиваем отображение границы кнопки
    val greenColor = colorResource(id = R.color.green)
    val redColor = colorResource(id = R.color.red)
    val borderColor by remember(status) {
        mutableStateOf(
            when (status) {
                AnswerVariantViewStatus.CORRECT -> greenColor
                AnswerVariantViewStatus.INCORRECT -> redColor
                else -> Color.Transparent
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                enabled = status == AnswerVariantViewStatus.DEFAULT_UNCHECKED,
                onClick = onClick
            )
            .background(colorResource(id = R.color.secondary_background))
            .border(2.dp, borderColor, RoundedCornerShape(12.dp))
            .alpha(1f)
            .padding(24.dp),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}