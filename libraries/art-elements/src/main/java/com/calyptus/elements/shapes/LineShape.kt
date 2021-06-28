package com.calyptus.artelement.shapes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent

class LineShape : Shape {

    private val linePoints = FloatArray(4)

    override fun draw(context: Context, canvas: Canvas, paint: Paint) {
        paint.let { canvas.drawLines(linePoints, it) }
    }

    override fun onTouch(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                linePoints.let { it[0] = event.x }
                linePoints.let { it[1] = event.y }
                linePoints.let { it[2] = event.x }
                linePoints.let { it[3] = event.y }
            }
            MotionEvent.ACTION_MOVE -> {
                linePoints.let { it[2] = event.x }
                linePoints.let { it[3] = event.y }
            }
            else -> {

            }
        }
    }

    override fun clone() : Shape {
        val lineShape = LineShape()
        lineShape.linePoints[0] = this.linePoints[0]
        lineShape.linePoints[1] = this.linePoints[1]
        lineShape.linePoints[2] = this.linePoints[2]
        lineShape.linePoints[3] = this.linePoints[3]
        return lineShape;
    }

    override fun reset() {
        this.linePoints[0] = 0.0f
        this.linePoints[1] = 0.0f
        this.linePoints[2] = 0.0f
        this.linePoints[3] = 0.0f
    }

}