package com.example.colordemoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun ColorContainerView(isSelected: Boolean, hexValue: String, modifier: Modifier) {
    val color = Color(getColorFromHex(hexValue))
    val invertedColor = getContrastForColor(color)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = color)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = hexValue,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp, 0.dp),
                color = invertedColor,
                fontWeight = FontWeight.Bold
            )
            val imageVector = if (isSelected) {
                Icons.Default.Lock
            } else {
                Icons.Default.Delete
            }
            Icon(
                imageVector = imageVector,
                contentDescription = "Lock color",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
        }

    }

}

fun getContrastForColor(color: Color): Color {
    val average = listOf(color.red,color.blue,color.green).average()
    return if (average > 0.5f) {
        Color.Black
    } else {
        Color.White
    }
}

fun getColorFromHex(colorHexString: String): Int {
    var color = colorHexString
    if (!colorHexString.contains("#")) {
        color = "#${colorHexString}"
    }
    return color.toColorInt()
}


@Preview(showBackground = true, widthDp = 200, heightDp = 500)
@Composable
fun ColorContainerPreview() {
    Column() {
        ColorContainerView(isSelected = true, hexValue = "#3131d3", Modifier.weight(1f))
        ColorContainerView(isSelected = false, hexValue = "#c930da", Modifier.weight(1f))
    }
}