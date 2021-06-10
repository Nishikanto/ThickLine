package com.calyptus.thikline.drawingcomponents

import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View

interface DrawingTool {
    fun setTouchEvent(v: View?, event: MotionEvent?)
    fun setView(drawingView: View?)
    fun setDrawings(drawingData: DrawingData?)
}