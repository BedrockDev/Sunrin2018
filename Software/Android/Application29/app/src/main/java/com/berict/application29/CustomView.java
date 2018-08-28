package com.berict.application29;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static android.view.View.MeasureSpec.AT_MOST;
import static android.view.View.MeasureSpec.EXACTLY;

public class CustomView extends View {

    int color = Color.RED;
    Context context;

    public CustomView(Context context) {
        super(context);
        this.context = context;
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);

        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        
        int width = 0;
        int height = 0;
        
        if (wMode == AT_MOST) {
            width = 900;
        } else if (widthMeasureSpec == EXACTLY) {
            width = wSize;
        }

        if (hMode == AT_MOST) {
            height = 900;
        } else if (heightMeasureSpec == EXACTLY) {
            height = hSize;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawLine(20, 50, 350, 50, paint);
        canvas.drawRect(20, 110, 350, 250, paint);
        canvas.drawCircle(100, 430, 100, paint);
        paint.setTextSize(50);
        canvas.drawText("Sample Text", 20, 700, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        color = 0xFF0000FF;
        invalidate();
        Toast.makeText(context, "Event triggered", Toast.LENGTH_SHORT).show();
        return true;
    }
}
