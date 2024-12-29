package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mustafin.languages.core.ui.customComponents.buttons.CustomButton
import com.mustafin.languages.core.utils.lessonUtils.InformationUnitModel

/* View ступени урока с информацией */
@Composable
fun LessonInformationUnitView(content: InformationUnitModel, onButtonClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = content.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = content.text,
                style = MaterialTheme.typography.labelMedium
            )
        }

        CustomButton(
            text = content.buttonText,
            modifier = Modifier.fillMaxWidth(),
            onCLick = onButtonClick
        )
    }
}