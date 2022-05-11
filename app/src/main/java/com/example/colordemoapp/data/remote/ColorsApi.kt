package com.example.colordemoapp.data.remote

import com.example.colordemoapp.data.remote.dto.PaletteDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ColorsApi {

    @GET("palette/from/{hexValue}")
    suspend fun getPaletteFromColor(
        @Path("hexValue") hexValue: String,
    ): List<PaletteDto>
    //https://www.colourlovers.com/api/palettes/random/?format=json&numresults=1
    @GET("palettes/random/?format=json&numresults=1")
    suspend fun getPalette(): List<PaletteDto>

}