package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

/**
 * @author Nishikanto Sarkar
 */
class DrawingView : View, OnTouchListener {

    private var drawingTool: DrawingTool? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    private fun init() {
        setOnTouchListener(this)
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
        drawingTool?.onDraw(canvas)
    }

    fun use(drawingTool: DrawingTool) {
        this.drawingTool = drawingTool
        drawingTool.setView(this)
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        drawingTool?.setTouchEvent(v, event)
        return true
    }
}