package com.calyptus.thikline

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.calyptus.myapplication.R
import com.calyptus.thikline.drawingcomponents.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val lineShape = LineShape()
    private val pencilShape = PencilShape()
    private val rectangleShape = RectangleShape()
    private val ovalShape = OvalShape()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artBoard.setPaint(PaintFactory().getPaint(this))
        artBoard.setShapeType(PencilShape())
    }

    override fun onResume() {
        super.onResume()
        artBoard?.invalidate()
    }

    fun buttonClicked(view: View) {
        when (view.id) {
            R.id.pencilBtn -> {
                artBoard.setShapeType(pencilShape)
            }
            R.id.lineBtn -> {
                artBoard.setShapeType(lineShape)
            }
            R.id.rectangleBtn -> {
                artBoard.setShapeType(rectangleShape)
            }
            R.id.ovalBtn -> {
                artBoard.setShapeType(ovalShape)
            }
        }
    }

}

