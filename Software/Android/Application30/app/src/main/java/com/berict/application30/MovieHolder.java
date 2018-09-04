package com.berict.application30;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieHolder {

    public ImageView image;
    public TextView title;
    public TextView genre;

    public MovieHolder(View v) {
        image = v.findViewById(R.id.imageView);
        title = v.findViewById(R.id.titleView);
        genre = v.findViewById(R.id.genreView);
    }
}
