package com.berict.application20;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LogHolder {

    public TextView name;
    public ImageView image;
    public TextView date;
    public ImageView phone;

    public LogHolder(View root) {
        image = root.findViewById(R.id.list_person);
        name = root.findViewById(R.id.list_name);
        date = root.findViewById(R.id.list_date);
        phone = root.findViewById(R.id.list_phone);
    }
}
