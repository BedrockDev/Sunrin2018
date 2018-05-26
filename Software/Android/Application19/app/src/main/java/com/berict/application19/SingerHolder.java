package com.berict.application19;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SingerHolder {

    public ImageView image;
    public TextView text1;
    public TextView text2;
    public TextView text3;

    public SingerHolder(View root) {
        image = root.findViewById(R.id.imageView);
        text1 = root.findViewById(R.id.textView1);
        text2 = root.findViewById(R.id.textView2);
        text3 = root.findViewById(R.id.textView3);
    }
}
