package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.calyptus.myapplication.R
import java.util.*

class Pencil(context: Context?) : DrawingTool {
    var path: Path? = null
    var paint: Paint = Paint()
    private var drawingView: View? = null
    private var paths: ArrayList<Path>? = null


    override fun setTouchEvent(v: View?, event: MotionEvent?) {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                path = Path()
                path?.let { paths?.apply { add(it) } }
                path?.apply {  moveTo(event.x, event.y)}
                path?.apply { lineTo(event.x, event.y)}
                drawingView!!.invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                path?.apply { lineTo(event.x, event.y)}
                drawingView?.apply {  invalidate()}
            }
            MotionEvent.ACTION_UP -> {
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
        drawingData?.let { paths = it.paths }
    }

    init {
        paint.color = ContextCompat.getColor(context!!, R.color.black)
        paint.isAntiAlias = true
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
    }
}