package com.mustafin.languages.mainFlow.ui.screens.homeScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/* Главный экран приложения */
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val lessons by viewModel.lessons.collectAsStateWithLifecycle()

    LazyColumn {
        item {
            Spacer(modifier = Modifier.statusBarsPadding())
        }

        items(lessons) {
            Text(text = it.name, style = MaterialTheme.typography.displayLarge)
        }
    }
}