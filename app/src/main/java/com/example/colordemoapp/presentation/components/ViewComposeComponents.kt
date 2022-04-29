package com.example.colordemoapp.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.colordemoapp.data.remote.dto.ColorHexDto
import com.example.colordemoapp.presentation.ui.theme.ColorDemoAppTheme


@Composable
fun ColorDisplayItem(
    colorHexDto: ColorHexDto,
    onItemClick: (ColorHexDto) -> Unit?
) {
    Text(text = "alo")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorDemoAppTheme {
        ColorDisplayItem(colorHexDto = ColorHexDto("asd"), onItemClick = { null } )
    }
}