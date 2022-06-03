package com.example.colordemoapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.colordemoapp.presentation.components.ColorContainerState
import com.example.colordemoapp.presentation.components.ColorContainerView


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val state = homeViewModel.state.value
    val topSectionId = "topSection"
    val centerSectionId = "centerSection"
    val bottomSectionId = "bottomSection"
    val constraints = ConstraintSet {
        val topSection = createRefFor(topSectionId)
        val centerSection = createRefFor(centerSectionId)
        val bottomSection = createRefFor(bottomSectionId)

        constrain(topSection) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(centerSection.top)
            height = Dimension.wrapContent
            width = Dimension.fillToConstraints
        }
        constrain(centerSection) {
            top.linkTo(topSection.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(bottomSection.top)
            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        }
        constrain(bottomSection) {
            top.linkTo(centerSection.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            height = Dimension.wrapContent
            width = Dimension.fillToConstraints
        }
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .layoutId(topSectionId)
        ) {
            AppTitle(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .layoutId(centerSectionId)
        ) {
            CenterSection(state)
        }
        Box(
            modifier = Modifier
                .layoutId(bottomSectionId)
        ) {
            Button(
                modifier = Modifier
                    .padding(0.dp, 10.dp)
                    .align(Alignment.Center),
                shape = RoundedCornerShape(20.dp),
                onClick = {
                    homeViewModel.getRandomColors()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
            ) {
                Text(text = "Refresh!", color = Color.White)
            }
        }
    }
}

@Composable
fun CenterSection(state: HomeState) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        ColorsDisplayer(state)

        if (state.isLoading) {
            Box(modifier = Modifier.background(Color.White)) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun AppTitle(modifier: Modifier) {
    Text(
        modifier = modifier
            .padding(16.dp),
        text = "Color Demo App",
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp,
        style = TextStyle(fontWeight = FontWeight.ExtraBold)
    )
}

@Composable
fun ColorsDisplayer(state: HomeState) {
    Column(modifier = Modifier.fillMaxSize()) {
        val colorsInPalette = state.colorsForPalette
        val isLoading = state.isLoading
        val colorContainerState0 = ColorContainerState(isLoading, colorsInPalette?.colors?.get(0))
        val colorContainerState1 = ColorContainerState(isLoading, colorsInPalette?.colors?.get(1))
        val colorContainerState2 = ColorContainerState(isLoading, colorsInPalette?.colors?.get(2))
        val colorContainerState3 = ColorContainerState(isLoading, colorsInPalette?.colors?.get(3))
        val colorContainerState4 = ColorContainerState(isLoading, colorsInPalette?.colors?.get(4))

        ColorContainerView(
            colorContainerState = colorContainerState0,
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            colorContainerState = colorContainerState1,
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            colorContainerState = colorContainerState2,
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            colorContainerState = colorContainerState3,
            modifier = Modifier.weight(1f)
        )
        ColorContainerView(
            colorContainerState = colorContainerState4,
            modifier = Modifier.weight(1f)
        )

    }
}

@Composable
@Preview(showBackground = true, widthDp = 300, heightDp = 700)
fun HomeScreenPreview() {
    HomeScreen()

}