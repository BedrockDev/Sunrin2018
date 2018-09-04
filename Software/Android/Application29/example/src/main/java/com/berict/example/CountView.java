package com.berict.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.view.View.MeasureSpec.AT_MOST;
import static android.view.View.MeasureSpec.EXACTLY;

public class CountView extends View {

    Context context;

    int value;

    Bitmap plusBitmap, minusBitmap;
    Rect plusRectDst, minusRectDst;

    OnCountChangedListener listener;

    public CountView(Context context) {
        super(context);
        init(context);
    }

    public CountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void init(Context context) {
        this.context = context;

        plusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plus);
        minusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minus);

        plusRectDst = new Rect(10, 10, 210, 210);
        minusRectDst = new Rect(400, 10, 610, 210);
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
            width = 600;
        } else if (widthMeasureSpec == EXACTLY) {
            width = wSize;
        }

        if (hMode == AT_MOST) {
            height = 300;
        } else if (heightMeasureSpec == EXACTLY) {
            height = hSize;
        }

        setMeasuredDimension(width, height);
    }

    void setOnCountChangedListener(OnCountChangedListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect plusRectSrc = new Rect(0, 0, plusBitmap.getWidth(), plusBitmap.getHeight());
        Rect minusRectSrc = new Rect(0, 0, minusBitmap.getWidth(), minusBitmap.getHeight());

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawBitmap(plusBitmap, plusRectSrc, plusRectDst, null);
        canvas.drawText(String.valueOf(value), 260, 150, paint);
        canvas.drawBitmap(minusBitmap, minusRectSrc, minusRectDst, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (plusRectDst.contains(x, y) && event.getAction() == MotionEvent.ACTION_DOWN) {
            value++;
            listener.onChange(value);
            invalidate();
            return true;
        } else if (minusRectDst.contains(x, y) && event.getAction() == MotionEvent.ACTION_DOWN) {
            value--;
            listener.onChange(value);
            invalidate();
            return true;
        }

        return false;
    }
}
