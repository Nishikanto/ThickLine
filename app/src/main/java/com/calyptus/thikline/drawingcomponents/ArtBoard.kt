package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

/**
 * @author Nishikanto Sarkar
 */
class ArtBoard : View, OnTouchListener {

    private var activeShape: Shape? = null
    private var paint: Paint? = null
    private val history = History()

    private fun init() {
        setOnTouchListener(this)
    }

    constructor(context: Context?) : super(context) {
        init()
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

        for (layer in history.getLayers()) {
            paint?.let { layer.shape.draw(context, canvas, it) }
        }

        paint?.let { activeShape?.draw(context, canvas, it) }

    }


    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                activeShape?.onTouch(event)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                activeShape?.onTouch(event)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                val shape = activeShape?.clone()
                activeShape?.reset()
                shape?.let { history.push(Layer(shape)) }
            }
            else -> {

            }
        }
        return true
    }

    fun setShapeType(shape: Shape) {
        activeShape = shape
    }

    fun setPaint(paint: Paint) {
        this.paint = paint
    }
}