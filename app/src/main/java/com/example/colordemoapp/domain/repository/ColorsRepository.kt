package com.example.colordemoapp.domain.repository

import com.example.colordemoapp.data.remote.dto.ColorHexDto

interface ColorsRepository {

    suspend fun getPaletteFromColor(hexValue : String , monochromeValue : String) : List<ColorHexDto>

}