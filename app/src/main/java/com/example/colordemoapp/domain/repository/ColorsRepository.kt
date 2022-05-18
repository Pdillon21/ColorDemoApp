package com.example.colordemoapp.domain.repository

import com.example.colordemoapp.data.remote.dto.SchemeDto

interface ColorsRepository {

    suspend fun getPaletteFromColor(hexValue : String) : SchemeDto

    suspend fun getPallete() : SchemeDto

}