package com.mustafin.languages.mainFlow.ui.screens.homeScreen.views.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.mustafin.languages.R
import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel

/* Верхняя часть главного экрана(выбранный язык и др.) */
@Composable
fun HomeScreenHeader(language: ShortLanguageModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LanguageView(language)
    }
}

@Preview
@Composable
private fun HomeScreenHeaderPreview() {
    HomeScreenHeader(
        language = ShortLanguageModel(
            0,
            "Русский",
            R.drawable.russian
        )
    )
}