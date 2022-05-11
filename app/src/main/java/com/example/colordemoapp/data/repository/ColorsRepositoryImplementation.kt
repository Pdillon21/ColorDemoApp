package com.example.colordemoapp.data.repository

import com.example.colordemoapp.data.remote.ColorsApi
import com.example.colordemoapp.data.remote.dto.PaletteDto
import com.example.colordemoapp.domain.repository.ColorsRepository
import javax.inject.Inject

class ColorsRepositoryImplementation @Inject constructor(
    private val api: ColorsApi
) : ColorsRepository {

    override suspend fun getPaletteFromColor(
        hexValue: String
    ): List<PaletteDto> {
        return api.getPaletteFromColor(hexValue)
    }

    override suspend fun getPallete(): List<PaletteDto> {
        return api.getPalette()
    }

}