package com.mustafin.languages.mainFlow.ui.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafin.languages.core.utils.LoadingState
import com.mustafin.languages.core.utils.lessonUtils.ShortLessonModel
import com.mustafin.languages.mainFlow.data.repositories.lessonsRepository.LessonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val lessonsRepository: LessonsRepository
) : ViewModel() {
    private val _loadingState = MutableStateFlow(LoadingState.LOADING)
    val loadingState: StateFlow<LoadingState> = _loadingState

    private val _lessons = MutableStateFlow(emptyList<ShortLessonModel>())
    val lessons: StateFlow<List<ShortLessonModel>> = _lessons

    init {
        viewModelScope.launch {
            _lessons.value = lessonsRepository.getLessonsByLanguageId(0)
            _loadingState.value = LoadingState.LOADED
            println(_lessons)
        }
    }
}