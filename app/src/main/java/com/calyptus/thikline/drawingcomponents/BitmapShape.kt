package com.calyptus.thikline.drawingcomponents

import android.graphics.Bitmap

interface BitmapShape : Shape {
    fun onBitmapSelected(bitmap : Bitmap)
}