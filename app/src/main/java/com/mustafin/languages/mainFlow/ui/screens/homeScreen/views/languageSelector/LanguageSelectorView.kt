package com.mustafin.languages.mainFlow.ui.screens.homeScreen.views.languageSelector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/* View с выпадающим списком для выбора языка */
@Composable
fun LanguageSelectorView(
    selectedLanguageIndex: Int,
    onSelectLanguage: (Int) -> Unit, // В лямбду передается индекс языка
    viewModel: LanguageSelectorViewModel = hiltViewModel()
) {
    val languages =
        viewModel.languages.collectAsStateWithLifecycle()
    val selectedLanguage =
        viewModel.selectedLanguage.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.selectLanguage(selectedLanguageIndex)
    }

    languages.value?.let {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(it) { lang ->
                LanguageView(
                    language = lang,
                    isSelected = selectedLanguage.value == lang,
                    onClick = {
                        viewModel.selectLanguage(lang.id)
                        onSelectLanguage(lang.id)
                    }
                )
            }
        }
    }
}


@Preview
@Composable
private fun LanguageViewPreview() {
    LanguageSelectorView(
        selectedLanguageIndex = 0,
        onSelectLanguage = {}
    )
}