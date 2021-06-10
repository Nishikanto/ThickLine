package com.calyptus.thikline.drawingcomponents;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public interface DrawingTool {
    void setTouchEvent(View v, MotionEvent event);
    void setView(View drawingView);
    void onDraw(Canvas canvas);
}
