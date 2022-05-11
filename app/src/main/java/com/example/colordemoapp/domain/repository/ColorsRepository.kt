package com.example.colordemoapp.domain.repository

import com.example.colordemoapp.data.remote.dto.PaletteDto

interface ColorsRepository {

    suspend fun getPaletteFromColor(hexValue : String) : List<PaletteDto>

    suspend fun getPallete() : List<PaletteDto>

}