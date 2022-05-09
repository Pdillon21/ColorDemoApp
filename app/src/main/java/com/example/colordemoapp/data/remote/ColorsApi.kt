package com.example.colordemoapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ColorsApi {

    @GET("palette/from/{hexValue}")
    suspend fun getPaletteFromColor(
        @Path("hexValue") hexValue: String,
    ): List<String>

}