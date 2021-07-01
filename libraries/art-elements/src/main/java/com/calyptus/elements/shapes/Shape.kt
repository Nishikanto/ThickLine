package com.calyptus.elements.shapes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
/**
 * @author Nishikanto Sarkar
 */
interface Shape {
    fun draw(context : Context, canvas: Canvas, paint: Paint)
    fun onTouch(event: MotionEvent)
    fun clone(): Shape
    fun reset()
}