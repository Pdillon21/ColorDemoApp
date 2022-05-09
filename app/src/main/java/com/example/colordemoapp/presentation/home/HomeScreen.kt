package com.example.colordemoapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.colordemoapp.presentation.components.ColorContainerView
import com.example.colordemoapp.presentation.ui.theme.ColorDemoAppTheme


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val state = homeViewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center)) {
            val textMessage = if (state.colorsForPalette.isNullOrEmpty()){
                "Display Colors"
            } else {
                getStringOfColors(state.colorsForPalette)
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = textMessage, color = Color.Black, modifier = Modifier.align(CenterHorizontally))
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { homeViewModel.getColorsOpen() }, modifier = Modifier.align(CenterHorizontally)){
                Text(text = "Click")
            }
            if (state.error.isNotEmpty()){
                Text(text = state.error, color = Color.Red)
            }
        }
    }
    if (state.isLoading){
        CircularProgressIndicator()
    }
    ColorsDisplayer()
}

@Composable
fun ColorsDisplayer (){
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
    for(color in colorsForPalette) {
        textToDisplay += "-${color}"
    }
    return textToDisplay
}


@Composable
@Preview(showBackground = true, widthDp = 300, heightDp = 700)
fun HomeScreenPreview (){
    ColorDemoAppTheme() {
        HomeScreen()
    }
}