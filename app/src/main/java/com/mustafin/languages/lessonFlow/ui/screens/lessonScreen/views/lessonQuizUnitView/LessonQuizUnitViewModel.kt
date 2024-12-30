package com.mustafin.languages.lessonFlow.ui.screens.lessonScreen.views.lessonQuizUnitView

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/* Вью модель блока теста */
class LessonQuizUnitViewModel: ViewModel() {
    private val _selectedAnswerIndex = MutableStateFlow<Int?>(null)
    val selectedAnswerIndex: StateFlow<Int?> = _selectedAnswerIndex

    fun resetState() {
        _selectedAnswerIndex.value = null
    }

    fun onSelectAnswerClick(selectedIndex: Int?) {
        if (selectedAnswerIndex.value != null) return
        _selectedAnswerIndex.value = selectedIndex
    }
}