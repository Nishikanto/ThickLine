package com.calyptus.thikline.drawingcomponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.calyptus.myapplication.R;

import java.util.ArrayList;

public class Pencil implements DrawingTool {

    Path path;
    Paint paint;
    private View drawingView;
    private ArrayList<Path> paths = new ArrayList<>();

    public Pencil(Context context) {
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.black));
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public void setTouchEvent(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                path = new Path();
                paths.add(path);
                path.moveTo(event.getX(), event.getY());
                path.lineTo(event.getX(), event.getY());
                drawingView.invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                path.lineTo(event.getX(), event.getY());
                drawingView.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                v.performClick();
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void setView(View drawingView) {
        this.drawingView = drawingView;
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Path path : paths) {
            canvas.drawPath(path, paint);
        }
    }


}
