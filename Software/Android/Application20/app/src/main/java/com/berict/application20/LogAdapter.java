package com.berict.application20;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class LogAdapter extends ArrayAdapter {

    private Context context;
    private int resId;
    private ArrayList<LogItem> data;

    public LogAdapter(@NonNull Context context, int resource, @NonNull ArrayList<LogItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resId = resource;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resId, null);

            LogHolder holder = new LogHolder(view);
            view.setTag(holder);
        }

        final LogHolder holder = (LogHolder) view.getTag();
        final LogItem item = data.get(i);

        if (item != null) {
            holder.name.setText(item.name);

            if (item.image.equals("yes")) {
                holder.image.setImageDrawable(context.getDrawable(R.drawable.hong));
            } else {
                holder.image.setImageDrawable(context.getDrawable(R.drawable.ic_person));
            }

            if (item.date > 1) {
                holder.date.setText(item.date + " days ago");
            } else {
                holder.date.setText(item.date + " day ago");
            }
        }

        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + item.phone.replace("-", "")));
                context.startActivity(intent);
            }
        });

        return view;
    }
}
