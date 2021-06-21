package com.calyptus.thikline.drawingcomponents

import android.content.Context
import android.graphics.Paint
import androidx.core.content.ContextCompat
import com.calyptus.myapplication.R
import java.lang.NullPointerException

class PaintFactory {

    fun getPaint(context : Context?) : Paint {
        context?.let {
            val paint = Paint()
            paint.color = ContextCompat.getColor(context, R.color.black)
            paint.isAntiAlias = true
            paint.isDither = true
            paint.strokeWidth = 10f
            paint.style = Paint.Style.STROKE
            paint.strokeJoin = Paint.Join.ROUND
            paint.strokeCap = Paint.Cap.ROUND
            return paint
        }

        throw NullPointerException("Context can not be null")

    }

}