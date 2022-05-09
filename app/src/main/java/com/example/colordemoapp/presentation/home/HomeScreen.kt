package com.example.colordemoapp.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.colordemoapp.presentation.components.ColorContainerView
import com.example.colordemoapp.presentation.ui.theme.ColorDemoAppTheme


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val state = homeViewModel.state.value

    ColorsDisplayer()
    if (state.isLoading) {
        CircularProgressIndicator()
    }
}

@Composable
fun ColorsDisplayer() {
    Column(modifier = Modifier.fillMaxSize()) {
        ColorContainerView(isSelected = false, hexValue = "#00ff00", Modifier.weight(1f))
        ColorContainerView(isSelected = false, hexValue = "#450012", Modifier.weight(1f))
        ColorContainerView(isSelected = true, hexValue = "#ff0000", Modifier.weight(1f))
        ColorContainerView(isSelected = false, hexValue = "#232323", Modifier.weight(1f))
        ColorContainerView(isSelected = false, hexValue = "#0000ff", Modifier.weight(1f))
    }
}

fun getStringOfColors(colorsForPalette: List<String>): String {
    var textToDisplay = ""
    for (color in colorsForPalette) {
        textToDisplay += "-${color}"
    }
    return textToDisplay
}


@Composable
@Preview(showBackground = true, widthDp = 300, heightDp = 700)
fun HomeScreenPreview() {
    ColorDemoAppTheme() {
        HomeScreen()
    }
}