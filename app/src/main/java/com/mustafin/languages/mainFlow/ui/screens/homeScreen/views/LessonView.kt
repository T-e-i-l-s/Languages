package com.mustafin.languages.mainFlow.ui.screens.homeScreen.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.mustafin.languages.R
import com.mustafin.languages.core.ui.customComponents.buttons.TinyButton
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel

/* View блока с краткой информацией о уроке */
@Composable
fun LessonView(lesson: ShortLessonModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource(id = R.color.secondary_background))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = lesson.name,
            style = MaterialTheme.typography.titleSmall
        )

        when (lesson.done) {
            true -> {
                Text(
                    text = stringResource(id = R.string.lesson_done),
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.green)
                )
            }

            false -> {
                Text(
                    text = stringResource(id = R.string.lesson_not_done),
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.gray)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        TinyButton(
            text = when (lesson.done) {
                true -> stringResource(id = R.string.start_lesson_again)
                false -> stringResource(id = R.string.start_lesson)
            },
            containerColor = when (lesson.done) {
                true -> colorResource(id = R.color.content)
                false -> colorResource(id = R.color.additional)
            }
        ) {}
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
        )

        Spacer(modifier = Modifier.height(12.dp))

        LessonView(
            lesson = ShortLessonModel(
                0,
                LoremIpsum(3).values.first(),
                false
            )
        )
    }
}