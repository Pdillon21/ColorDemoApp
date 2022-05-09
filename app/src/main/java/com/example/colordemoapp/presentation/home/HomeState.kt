package com.example.colordemoapp.presentation.home

data class HomeState(
    val isLoading: Boolean = false,
    val colorsForPalette: List<String> = emptyList(),
    val error: String = ""
)