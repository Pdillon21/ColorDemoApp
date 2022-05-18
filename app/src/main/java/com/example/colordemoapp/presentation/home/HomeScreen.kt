package com.example.colordemoapp.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.colordemoapp.data.remote.dto.SchemeDto
import com.example.colordemoapp.presentation.components.ColorContainerView
import com.example.colordemoapp.presentation.ui.theme.ColorDemoAppTheme


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val state = homeViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.colorsForPalette != null) {
            ColorsDisplayer(state.colorsForPalette)
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .absoluteOffset(0.dp, (-36).dp)
            )
        }
        Box(modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .clickable {
                homeViewModel.getRandomColors()
            }
            .align(Alignment.Center)
        ) {
            Text(text = "Button")
        }

    }
}

@Composable
fun ColorsDisplayer(colorsForPalette: SchemeDto) {
    Column(modifier = Modifier.fillMaxSize()) {
        val colorsInPalette = colorsForPalette.colors
        ColorContainerView(
            isSelected = false,
            colorDto = colorsInPalette[0],
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            isSelected = false,
            colorDto = colorsInPalette[1],
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            isSelected = false,
            colorDto = colorsInPalette[2],
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            isSelected = false,
            colorDto = colorsInPalette[3],
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            isSelected = false,
            colorDto = colorsInPalette[4],
            modifier = Modifier.weight(1f)
        )

    }
}

@Composable
@Preview(showBackground = true, widthDp = 300, heightDp = 700)
fun HomeScreenPreview() {
    ColorDemoAppTheme() {
        HomeScreen()
    }
}