package com.calyptus.artboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.calyptus.elements.paints.PaintFactory
import com.calyptus.elements.shapes.LineShape
import com.calyptus.elements.shapes.OvalShape
import com.calyptus.elements.shapes.PencilShape
import com.calyptus.elements.shapes.RectangleShape
import kotlinx.android.synthetic.main.activity_art_board.*

class ArtBoardActivity : AppCompatActivity() {

    private val lineShape = LineShape()
    private val pencilShape = PencilShape()
    private val rectangleShape = RectangleShape()
    private val ovalShape = OvalShape()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art_board)


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