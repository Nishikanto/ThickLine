package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.core.content.ContextCompat
import com.calyptus.myapplication.R

/**
 * @author Nishikanto Sarkar
 */
class DrawingView : View, OnTouchListener {

    private var drawingTool: DrawingTool? = null
    private var drawingData: DrawingData? = null

    private val paint: Paint = Paint()

    constructor(context: Context?) : super(context) {
        init()
    }

    private fun init() {
        setOnTouchListener(this)
        drawingData = DrawingData(
            ArrayList(),
            ArrayList(),
            ArrayList(),
            ArrayList()
        )

        paint.color = ContextCompat.getColor(context, R.color.black)
        paint.isAntiAlias = true
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawingData?.lines?.let {
            for (linePoints in it) {
                canvas.drawLines(linePoints, paint)
            }
        }

        drawingData?.ovals?.let {
            for (rectF in it) {
                canvas.drawOval(rectF, paint)
            }
        }

        drawingData?.paths?.let {
            for (path in it) {
                canvas.drawPath(path, paint)
            }
        }

        drawingData?.rects?.let {
            for (rectF in it) {
                canvas.drawRect(rectF, paint)
            }
        }


    }

    fun use(drawingTool: DrawingTool) {
        this.drawingTool = drawingTool
        drawingTool.setView(this)
        drawingTool.setDrawings(drawingData)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        drawingTool?.setTouchEvent(v, event)
        return true
    }
}