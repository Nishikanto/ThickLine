package com.calyptus.thikline.drawingcomponents;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.calyptus.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Line implements DrawingTool{

    private final Context mContext;
    private final Paint paint;
    private int lastIndex;
    private View drawingView;
    private float[] linePoints;
    private ArrayList<float[]> lines;

    public Line(Context context){
        mContext = context;
        paint = new Paint();
        lines = new ArrayList<>();
        lastIndex = 0;

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
                linePoints = new float[4];
                lines.add(linePoints);
                linePoints[lastIndex + 0] = event.getX();
                linePoints[lastIndex + 1] = event.getY();
                linePoints[lastIndex + 2] = event.getX();
                linePoints[lastIndex + 3] = event.getY();
                drawingView.invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                linePoints[lastIndex + 2] = event.getX();
                linePoints[lastIndex + 3] = event.getY();
                drawingView.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                linePoints[lastIndex + 2] = event.getX();
                linePoints[lastIndex + 3] = event.getY();
                drawingView.invalidate();
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
        if(linePoints == null){
            return;
        }

        for(float[] linePoints : lines) {
            canvas.drawLines(linePoints, paint);
        }
    }
}
