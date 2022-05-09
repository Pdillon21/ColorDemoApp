package com.example.colordemoapp.presentation

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.colordemoapp.presentation.home.HomeScreen
import com.example.colordemoapp.presentation.ui.theme.ColorDemoAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorDemoAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ApiTestDisplay()
                }
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}

@Composable
fun ApiTestDisplay() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorDemoAppTheme {
        HomeScreen()
    }
}