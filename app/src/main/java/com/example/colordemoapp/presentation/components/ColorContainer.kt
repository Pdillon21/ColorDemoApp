package com.example.colordemoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.core.graphics.toColorInt
import com.example.colordemoapp.data.remote.dto.ColorDto
import com.example.colordemoapp.data.remote.dto.ContrastData
import com.example.colordemoapp.data.remote.dto.HexData
import com.example.colordemoapp.data.remote.dto.NameData

@Composable
fun ColorContainerView(colorContainerState: ColorContainerState, modifier: Modifier) {
    fun updateColor() {}
    colorContainerState.colorData?.let { colorDto ->
        colorDto.hex.value.let { colorString ->

            val iconContainerId = "iconContainer"
            val loadingContainerId = "loadingContainer"
            val textContainerId = "textContainerid"
            val constrains = ConstraintSet {
                val iconSection = createRefFor(iconContainerId)
                val textContainerSection = createRefFor(textContainerId)
                val loadingSection = createRefFor(loadingContainerId)
                constrain(iconSection) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                constrain(textContainerSection) {
                    bottom.linkTo(iconSection.bottom)
                    start.linkTo(parent.start)
                }
                constrain(loadingSection) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            }
            if (colorContainerState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.wrapContentSize())
            }
            ConstraintLayout(
                constrains,
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(getColorFromHex(colorString)))
            ) {
                SetIcon(
                    modifier = Modifier
                        .layoutId(iconContainerId)
                        .padding(
                            16.dp,
                            16.dp
                        ),
                    locked = colorContainerState.isLocked
                )
                SetColorText(
                    modifier = Modifier
                        .layoutId(textContainerId)
                        .padding(
                            16.dp,
                            16.dp
                        ),
                    colorDto = colorDto
                )
            }
        }
    }

}

@Composable
fun SetIcon(modifier: Modifier, locked: Boolean) {
    val imageVector = if (locked) {
        Icons.Default.Lock
    } else {
        Icons.Default.Delete
    }
    Icon(
        imageVector = imageVector,
        contentDescription = "Lock color",
        modifier = modifier
            .height(24.dp)
            .width(24.dp)
    )
}

@Composable
fun SetColorText(colorDto: ColorDto, modifier: Modifier) {
    Column(modifier = modifier) {
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
    val colorContainerState1: ColorContainerState =
        ColorContainerState(isLoading = false, colorData = color1, isLocked = false)
    val colorContainerState2: ColorContainerState =
        ColorContainerState(isLoading = false, colorData = color2, isLocked = true)
    val colorContainerState3: ColorContainerState =
        ColorContainerState(isLoading = true, colorData = color1, isLocked = false)
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            ColorContainerView(colorContainerState1, modifier = Modifier)
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            ColorContainerView(colorContainerState2, modifier = Modifier)
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            ColorContainerView(colorContainerState3, modifier = Modifier)
        }
    }
}