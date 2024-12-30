package com.mustafin.languages.mainFlow.ui.screens.homeScreen.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.mustafin.languages.R
import com.mustafin.languages.core.ui.customComponents.buttons.TinyButton
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel

/* View блока с краткой информацией о уроке */
@Composable
fun LessonView(lesson: ShortLessonModel, startLesson: (Int) -> Unit) {
    Row(
        Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource(id = R.color.secondary_background))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier.weight(1f)
        ) {
            Text(
                text = lesson.name,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            TinyButton(
                text = when (lesson.done) {
                    true -> stringResource(id = R.string.start_lesson_again)
                    false -> stringResource(id = R.string.start_lesson)
                },
                containerColor = Color.Transparent,
                contentColor = colorResource(id = R.color.additional),
                modifier = Modifier.border(
                    2.dp,
                    colorResource(id = R.color.additional),
                    CircleShape
                )
            ) { startLesson(lesson.id) }
        }

        if (lesson.done) {
            Icon(
                painter = painterResource(id = R.drawable.check_icon2),
                contentDescription = null,
                tint = colorResource(id = R.color.green),
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Preview
@Composable
private fun LessonViewPreview() {
    Column {
        LessonView(
            lesson = ShortLessonModel(
                0,
                LoremIpsum(3).values.first(),
                true
            )
        ) {}

        Spacer(modifier = Modifier.height(12.dp))

        LessonView(
            lesson = ShortLessonModel(
                0,
                LoremIpsum(3).values.first(),
                false
            )
        ) {}
    }
}