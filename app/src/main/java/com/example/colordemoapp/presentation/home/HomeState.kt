package com.example.colordemoapp.presentation.home

import com.example.colordemoapp.data.remote.dto.ColorHexDto

data class HomeState(
    val isLoading: Boolean = false,
    val colorsForPalette: List<ColorHexDto> = emptyList(),
    val error: String = ""
)