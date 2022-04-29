package com.example.colordemoapp.data.repository

import com.example.colordemoapp.data.remote.ColorsApi
import com.example.colordemoapp.data.remote.dto.ColorHexDto
import com.example.colordemoapp.domain.repository.ColorsRepository
import javax.inject.Inject

class ColorsRepositoryImplementation @Inject constructor(private val api : ColorsApi) : ColorsRepository{

    override suspend fun getPaletteFromColor(
        hexValue: String,
        monochromeValue: String
    ): List<ColorHexDto> {
        TODO("Not yet implemented")
    }

}