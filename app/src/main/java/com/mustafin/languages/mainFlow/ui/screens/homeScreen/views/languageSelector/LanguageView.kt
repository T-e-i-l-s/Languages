package com.mustafin.languages.mainFlow.ui.screens.homeScreen.views.languageSelector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mustafin.languages.R
import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel

/* View с базовой информацией о языке(флаг и название) */
@Composable
fun LanguageView(
    language: ShortLanguageModel,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .background(colorResource(id = R.color.secondary_background))
            .border(
                2.dp,
                if (isSelected) colorResource(id = R.color.additional) else Color.Transparent,
                RoundedCornerShape(12.dp)
            )
            .padding(vertical = 8.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = language.iconResId),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = language.name,
            style = MaterialTheme.typography.labelMedium
        )
    }
}


@Preview
@Composable
private fun LanguageViewPreview() {
    Column {
        LanguageView(
            language = ShortLanguageModel(
                0,
                "Русский",
                R.drawable.russian
            ),
            true,
            {},
        )

        Spacer(modifier = Modifier.height(12.dp))

        LanguageView(
            language = ShortLanguageModel(
                0,
                "Русский",
                R.drawable.russian
            ),
            false,
            {},
        )
    }
}