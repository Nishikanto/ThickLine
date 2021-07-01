package com.calyptus.elements.shapes

import android.graphics.Bitmap

/**
 * @author Nishikanto Sarkar
 */
interface BitmapShape : Shape {
    fun onBitmapSelected(bitmap : Bitmap)
}