package com.example.capitalflow.screen.earning

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EarningScreen() {
    val viewModel = koinViewModel<EarningViewModel>()
    val uiState by viewModel.uiState.collectAsState()
}