package com.example.colordemoapp.common

import android.graphics.Color
import okhttp3.internal.toHexString
import java.util.Random

object ColorUtils {

    fun getRandomColor(): String {
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        val colorString = color.toHexString().drop(2)
        return colorString
    }
}