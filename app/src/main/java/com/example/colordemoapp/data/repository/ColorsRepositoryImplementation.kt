package com.example.colordemoapp.data.repository

import com.example.colordemoapp.common.ColorUtils
import com.example.colordemoapp.data.remote.ColorsApi
import com.example.colordemoapp.data.remote.dto.SchemeDto
import com.example.colordemoapp.domain.repository.ColorsRepository
import javax.inject.Inject

class ColorsRepositoryImplementation @Inject constructor(
    private val api: ColorsApi
) : ColorsRepository {

    override suspend fun getPaletteFromColor(
        hexValue: String
    ): SchemeDto {
        return api.getPaletteFromColor(hexValue)
    }

    override suspend fun getPallete(): SchemeDto {
        return api.getPalette(hexValue = ColorUtils.getRandomColor())
    }

}