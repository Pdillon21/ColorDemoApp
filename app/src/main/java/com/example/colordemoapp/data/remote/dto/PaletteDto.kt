package com.example.colordemoapp.data.remote.dto

data class PaletteDto(
    val apiUrl: String,
    val badgeUrl: String,
    val colors: List<String>,
    val dateCreated: String,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val numComments: Int,
    val numHearts: Int,
    val numViews: Int,
    val numVotes: Int,
    val rank: Int,
    val title: String,
    val url: String,
    val userName: String
)