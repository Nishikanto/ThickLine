package com.calyptus.thikline.drawingcomponents

import android.graphics.Path
import android.graphics.RectF
import java.util.*
import kotlin.collections.ArrayList

data class DrawingData(
    val lines: ArrayList<FloatArray>,
    val ovals: ArrayList<RectF>,
    val paths : ArrayList<Path>,
    val rects: ArrayList<RectF>,
    ){
}
