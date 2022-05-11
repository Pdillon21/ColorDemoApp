package com.example.colordemoapp.presentation.home

import com.example.colordemoapp.data.remote.dto.PaletteDto

data class HomeState(
    val isLoading: Boolean = false,
    val colorsForPalette: List<PaletteDto> = emptyList(),
    val error: String = ""
)