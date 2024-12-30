package com.mustafin.languages.mainFlow.ui.screens.homeScreen.views.languageSelector

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafin.languages.core.utils.languageUtils.ShortLanguageModel
import com.mustafin.languages.mainFlow.data.repositories.languagesRepository.LanguagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/* Вью модель для вью выбора языка */
@HiltViewModel
class LanguageSelectorViewModel @Inject constructor(
    private val languageRepository: LanguagesRepository
) : ViewModel() {
    private val _languages = MutableStateFlow<List<ShortLanguageModel>?>(null);
    val languages: StateFlow<List<ShortLanguageModel>?> = _languages

    private val _selectedLanguage = MutableStateFlow<ShortLanguageModel?>(null)
    val selectedLanguage: StateFlow<ShortLanguageModel?> = _selectedLanguage

    init {
        viewModelScope.launch {
            _languages.value = languageRepository.getLanguages()
        }
    }

    fun selectLanguage(languageIndex: Int) {
        languages.value?.let { languages ->
            _selectedLanguage.value = languages.find { it.id == languageIndex }
        }
    }
}