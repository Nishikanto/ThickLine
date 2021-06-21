package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.calyptus.myapplication.R

class OvalShape: Shape {

    private var rectF = RectF()

    override fun draw(context: Context, canvas: Canvas, paint: Paint) {
        paint.let { canvas.drawOval(rectF, it) }
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
        val ovalShape = OvalShape()
        ovalShape.rectF.set(this.rectF)
        return ovalShape
    }

    override fun reset() {
        this.rectF.set(0f,0f,0f,0f)
    }

}