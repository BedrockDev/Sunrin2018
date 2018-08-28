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
import android.view.View;

public class CountView extends View {

    Context context;

    int value;

    Bitmap plusBitmap, minusBitmap;
    Rect plusRectDst, minusRectDst;

    public CountView(Context context) {
        super(context);
        init();
    }

    public CountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    void init() {
        plusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plus);
        minusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minus);

        plusRectDst = new Rect(10, 10, 210, 210);
        minusRectDst = new Rect(400, 10, 610, 210);
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
}
