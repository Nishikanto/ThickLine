package com.calyptus.elements.shapes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.view.MotionEvent
import kotlin.math.abs

/**
 * @author Nishikanto Sarkar
 */
class PencilShape : Shape {

    private val path = Path()
    var lastPoint = PointF()

    override fun draw(context: Context, canvas: Canvas, paint: Paint) {
        paint.let { canvas.drawPath(path, it) }
    }

    override fun onTouch(event: MotionEvent) {
        when (event.action) {

            MotionEvent.ACTION_DOWN -> {

                path.reset()
                path.apply { moveTo(event.x, event.y) }
                path.apply { lineTo(event.x, event.y) }

                lastPoint.set(event.x, event.y)
            }

            MotionEvent.ACTION_MOVE -> {

                val dx = abs(event.x - lastPoint.x)
                val dy = abs(event.y - lastPoint.y)

                val controlPoint = PointF(lastPoint.x, lastPoint.y)
                val endPoint = PointF((lastPoint.x + event.x) / 2f, (event.y + lastPoint.y) / 2f)

                if (dx >= 4 || dy >= 4) {
                    path.apply {
                        quadTo(controlPoint.x, controlPoint.y, endPoint.x, endPoint.y)
                    }
                }

                lastPoint.set(event.x, event.y)
            }

            else -> {

            }
        }
    }

    override fun clone(): Shape {
        val pencilShape = PencilShape()
        pencilShape.path.set(this.path)
        return pencilShape
    }

    override fun reset() {
        this.path.reset()
    }
}