package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent

class RectangleShape : Shape {

    private val rectF = RectF()

    override fun draw(context: Context, canvas: Canvas, paint: Paint) {
        paint.let { canvas.drawRect(rectF, it) }
    }

    override fun onTouch(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                rectF.apply { set(event.x, event.y, event.x, event.y) }
            }
            MotionEvent.ACTION_MOVE -> {
                rectF.apply { set(left, top, event.x, event.y) }
            }
            else -> {
            }
        }
    }

    override fun clone(): Shape {
        val rectangleShape = RectangleShape()
        rectangleShape.rectF.set(this.rectF)
        return rectangleShape
    }

    override fun reset() {
        this.rectF.set(0f,0f,0f,0f)
    }


}