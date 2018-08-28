package com.berict.example;

import android.content.Context;
import android.graphics.Bitmap;
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
    }

    public CountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
