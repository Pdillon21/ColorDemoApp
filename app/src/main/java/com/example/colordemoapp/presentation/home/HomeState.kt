package com.example.colordemoapp.presentation.home

import com.example.colordemoapp.data.remote.dto.SchemeDto

data class HomeState(
    val isLoading: Boolean = false,
    val colorsForPalette: SchemeDto? = null,
    val error: String = ""
)