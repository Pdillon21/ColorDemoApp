package com.example.colordemoapp.data.remote

import com.example.colordemoapp.data.remote.dto.ColorHexDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ColorsApi {

    @GET("palette/from/{hexValue}/over/{monochromeValue}")
    fun getPaletteFromColor(
        @Path("hexValue") hexValue: String,
        @Path("monochromeValue") monochromeValue: String
    ): List<ColorHexDto>

}