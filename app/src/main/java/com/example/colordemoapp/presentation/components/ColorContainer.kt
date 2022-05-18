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
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.colordemoapp.data.remote.dto.ColorDto
import com.example.colordemoapp.data.remote.dto.ContrastData
import com.example.colordemoapp.data.remote.dto.HexData
import com.example.colordemoapp.data.remote.dto.NameData

@Composable
fun ColorContainerView(isSelected: Boolean, colorDto: ColorDto, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(getColorFromHex(colorDto.hex.value))),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = colorDto.hex.value,
                    color = Color(getColorFromHex(colorDto.contrast.value)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = colorDto.name.value,
                    color = Color(getColorFromHex(colorDto.contrast.value)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }

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
    val color1: ColorDto = ColorDto(
        HexData("#ff00ff", "ff00ff"), NameData("TestColor", true),
        ContrastData("#00ff00")
    )
    val color2: ColorDto = ColorDto(
        HexData("#00ff00", "00ff00"), NameData("TestColor", true),
        ContrastData("#ff00ff")
    )
    Column() {
        ColorContainerView(isSelected = true, colorDto = color1, Modifier.weight(1f))
        ColorContainerView(isSelected = false, colorDto = color2, Modifier.weight(1f))
    }
}