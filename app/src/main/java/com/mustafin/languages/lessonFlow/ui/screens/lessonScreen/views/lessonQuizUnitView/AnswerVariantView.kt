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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.mustafin.languages.R
import com.mustafin.languages.core.utils.quizUtils.AnswerStatus

/* View кнопки с вариантом ответа */
@Composable
fun AnswerVariantView(text: String, status: AnswerStatus, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .background(colorResource(id = R.color.secondary_background))
            .border(
                2.dp,
                when (status) {
                    AnswerStatus.CORRECT -> colorResource(id = R.color.green)
                    AnswerStatus.INCORRECT -> colorResource(id = R.color.red)
                    else -> Color.Transparent
                },
                RoundedCornerShape(12.dp)
            )
            .alpha(if (status == AnswerStatus.DEFAULT_CHECKED) 0.5f else 1f)
            .padding(12.dp)
    ) {
        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}