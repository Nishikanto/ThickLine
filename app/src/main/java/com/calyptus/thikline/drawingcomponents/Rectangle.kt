package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.calyptus.myapplication.R

class Rectangle(context: Context) : DrawingTool {

    private var drawingView: View? = null
    private var rectF: RectF? = null

    private var rects = ArrayList<RectF>()
    private var paint = Paint()

    init {
        paint.color = ContextCompat.getColor(context, R.color.black)
        paint.isAntiAlias = true
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
    }

    override fun setTouchEvent(v: View?, event: MotionEvent?) {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                rectF = RectF()
                rectF?.let(rects::add)
                rectF?.apply { set(event.x, event.y, event.x, event.y) }
                drawingView?.invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                rectF?.apply { set(left, top, event.x, event.y) }
                drawingView?.invalidate()
            }
            MotionEvent.ACTION_UP -> {
                v!!.performClick()
            }
            else -> {
            }
        }
    }

    override fun setView(drawingView: View?) {
        this.drawingView = drawingView
    }

    override fun onDraw(canvas: Canvas?) {
        for (rectF in rects) {
            canvas?.apply { drawRect(rectF, paint) }
        }
    }

}