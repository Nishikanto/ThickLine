package com.calyptus.artelement.shapes

import android.graphics.Bitmap

interface BitmapShape : Shape {
    fun onBitmapSelected(bitmap : Bitmap)
}