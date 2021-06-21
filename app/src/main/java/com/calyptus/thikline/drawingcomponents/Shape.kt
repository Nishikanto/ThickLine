package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

interface Shape {
    fun draw(context : Context, canvas: Canvas, paint: Paint)
    fun onTouch(event: MotionEvent)
    fun clone(): Shape
    fun reset()
}