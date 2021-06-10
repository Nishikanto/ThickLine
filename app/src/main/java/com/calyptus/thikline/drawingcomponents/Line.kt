package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.calyptus.myapplication.R
import java.util.*

class Line(mContext: Context) : DrawingTool {

    private val paint: Paint = Paint()
    private val lastIndex: Int = 0
    private var drawingView: View? = null
    private var linePoints: FloatArray? = null
    private var lines: ArrayList<FloatArray>? = null

    override fun setTouchEvent(v: View?, event: MotionEvent?) {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                linePoints = FloatArray(4)
                linePoints?.let { lines?.apply { add(it) } }
                linePoints?.let { it[lastIndex + 0] = event.x }
                linePoints?.let { it[lastIndex + 1] = event.y }
                linePoints?.let { it[lastIndex + 2] = event.x }
                linePoints?.let { it[lastIndex + 3] = event.y }
                drawingView!!.invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                linePoints!![lastIndex + 2] = event.x
                linePoints!![lastIndex + 3] = event.y
                drawingView!!.invalidate()
            }
            MotionEvent.ACTION_UP -> {
                linePoints!![lastIndex + 2] = event.x
                linePoints!![lastIndex + 3] = event.y
                drawingView!!.invalidate()
                v?.performClick()
            }
            else -> {
            }
        }
    }

    override fun setView(drawingView: View?) {
        this.drawingView = drawingView
    }

    override fun setDrawings(drawingData: DrawingData?) {
        drawingData?.let { lines = it.lines }
    }

    init {
        paint.color = ContextCompat.getColor(mContext, R.color.black)
        paint.isAntiAlias = true
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
    }
}