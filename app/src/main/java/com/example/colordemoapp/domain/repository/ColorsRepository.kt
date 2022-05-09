package com.example.colordemoapp.domain.repository

interface ColorsRepository {

    suspend fun getPaletteFromColor(hexValue : String) : List<String>

    suspend fun getPallete() : List<String>

}