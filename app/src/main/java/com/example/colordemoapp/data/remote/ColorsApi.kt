package com.example.colordemoapp.data.remote

import com.example.colordemoapp.data.remote.dto.SchemeDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ColorsApi {

    @GET("palette/from/{hexValue}")
    suspend fun getPaletteFromColor(
        @Path("hexValue") hexValue: String,
    ): SchemeDto
    //https://www.colourlovers.com/api/palettes/random/?format=json&numresults=1
    //palettes/random/?format=json&numresults=1"

    @GET("scheme")
    suspend fun getPalette(
        @Query("hex") hexValue: String,
        @Query("format") format : String = "json",
        @Query ("mode") mode : String = "analogic",
        @Query ("count") count : String = "5"
    ): SchemeDto

}