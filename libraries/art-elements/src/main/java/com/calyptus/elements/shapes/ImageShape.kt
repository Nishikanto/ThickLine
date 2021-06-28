package com.calyptus.artelement.shapes

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.view.MotionEvent


class ImageShape : BitmapShape {


    private var bitmap: Bitmap? = null
    private val point = PointF()

    override fun onBitmapSelected(bitmap: Bitmap) {
        this.bitmap = scaleDown(bitmap, 300f, false)
    }

    override fun draw(context: Context, canvas: Canvas, paint: Paint) {
        bitmap?.let { canvas.drawBitmap(it, point.x, point.y, paint) }
    }

    override fun onTouch(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                point.x = event.x
                point.y = event.y
            }
            MotionEvent.ACTION_MOVE -> {
                point.x = event.x
                point.y = event.y
            }
            else -> {

            }
        }
    }

    override fun clone(): Shape {
        val imageShape = ImageShape()
        imageShape.bitmap = this.bitmap
        imageShape.point.set(this.point)
        return imageShape
    }

    override fun reset() {
        //bitmap = null
        //point.set(0f, 0f)
    }


    fun scaleDown(
        realImage: Bitmap, maxImageSize: Float,
        filter: Boolean
    ): Bitmap? {
        val ratio = Math.min(
            maxImageSize / realImage.width,
            maxImageSize / realImage.height
        )
        val width = Math.round(ratio * realImage.width)
        val height = Math.round(ratio * realImage.height)
        return Bitmap.createScaledBitmap(
            realImage, width,
            height, filter
        )
    }
}