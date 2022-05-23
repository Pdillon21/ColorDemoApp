package com.example.colordemoapp.data.remote.dto

data class ColorDto(
    val hex: HexData,
    val name: NameData,
    val contrast: ContrastData
)

data class ContrastData(
    val value: String
)

data class NameData(
    val value: String,
    val exact_match_name: Boolean
)

data class HexData(
    val value: String,
    val clean: String
)
