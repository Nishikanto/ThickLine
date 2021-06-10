package com.calyptus.thikline

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.calyptus.myapplication.R
import com.calyptus.thikline.drawingcomponents.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_panel.*

class MainActivity : AppCompatActivity() {

    private var pencil: DrawingTool? = null
    private var line: DrawingTool? = null
    private var rectangle: DrawingTool? = null
    private var oval: DrawingTool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pencil = Pencil(this)
        line = Line(this)
        rectangle = Rectangle(this)
        oval = Oval(this)

        pencilBtn.performClick()
    }

    override fun onResume() {
        super.onResume()
        drawingView?.invalidate()
    }

    fun buttonClicked(view: View) {
        when (view.id) {
            R.id.pencilBtn -> {
                pencil?.let { drawingView?.use(it) }
            }
            R.id.lineBtn -> {
                line?.let { drawingView.use(it) }
            }
            R.id.rectangleBtn -> {
                rectangle?.let { drawingView?.use(it) }
            }
            R.id.ovalBtn -> {
                oval?.let { drawingView?.use(it) }
            }

        }
    }

}

