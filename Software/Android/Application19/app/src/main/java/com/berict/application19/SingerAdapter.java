package com.berict.application19;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class SingerAdapter extends ArrayAdapter<SingerItem> {
    Context context;
    int resId;
    ArrayList<SingerItem> data;


    public SingerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SingerItem> objects) {
        super(context, resource, objects);
        this.context = context;
        resId = resource;
        data = objects;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            SingerHolder holder = new SingerHolder(convertView);
            convertView.setTag(holder);
        }

        SingerHolder holder = (SingerHolder) convertView.getTag();

        final SingerItem item = data.get(position);

        if (item.imageId != 0) {
            holder.image.setImageDrawable(
                    context.getResources().getDrawable(
                            item.imageId, null
                    )
            );
        }
        holder.text1.setText(item.name);
        holder.text2.setText(item.tel);
        holder.text3.setText(String.valueOf(item.memberCount));

        return convertView;
    }
}
