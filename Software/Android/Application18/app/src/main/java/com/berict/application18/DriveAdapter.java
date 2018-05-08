package com.berict.application18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DriveAdapter extends ArrayAdapter {

    private Context context;
    private int layoutId;
    private ArrayList<DriveVO> data;

    public DriveAdapter(@NonNull Context context, int resource, ArrayList<DriveVO> data) {
        super(context, resource);
        this.context = context;
        this.layoutId = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layoutId, null);

        ImageView type = convertView.findViewById(R.id.type_image);
        ImageView menu = convertView.findViewById(R.id.item_menu);
        TextView title = convertView.findViewById(R.id.item_title);
        TextView lastEdited = convertView.findViewById(R.id.item_date);

        String typeImage = data.get(position).type;
        int typeImageRes = 0;

        switch (typeImage) {
            case "doc":
                typeImageRes = R.drawable.ic_type_doc;
                break;
            case "img":
                typeImageRes = R.drawable.ic_type_image;
                break;
            case "file":
                typeImageRes = R.drawable.ic_type_file;
                break;
        }

        type.setImageDrawable(ResourcesCompat.getDrawable(
                context.getResources(),
                typeImageRes,
                null
        ));

        title.setText(data.get(position).title);
        lastEdited.setText(data.get(position).date);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        context,
                        "File [" + data.get(position).title + "] selected",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        return convertView;
    }
}
