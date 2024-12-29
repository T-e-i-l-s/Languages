package com.mustafin.languages.mainFlow.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mustafin.languages.R
import com.mustafin.languages.mainFlow.ui.screens.homeScreen.views.header.HomeScreenHeader

/* Главный экран приложения */
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val loadingState by viewModel.loadingState.collectAsStateWithLifecycle()
    val language by viewModel.language.collectAsStateWithLifecycle()
    val lessons by viewModel.lessons.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.statusBarsPadding())

            language?.let { lang ->
                HomeScreenHeader(language = lang)
            }
        }
    }
}