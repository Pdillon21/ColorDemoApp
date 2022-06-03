package com.example.colordemoapp.presentation.components

import com.example.colordemoapp.data.remote.dto.ColorDto

data class ColorContainerState(
    val isLoading: Boolean = true,
    val colorData: ColorDto? = null,
    val isLocked: Boolean = false
)