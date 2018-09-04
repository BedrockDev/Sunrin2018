package com.berict.application30;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter {

    ArrayList<Movie> items;
    Context context;
    int resId;

    public MovieAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.context = context;
        this.resId = resource;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, null);
            MovieHolder holder = new MovieHolder(convertView);
            convertView.setTag(holder);
        }

        MovieHolder holder = (MovieHolder) convertView.getTag();
        ImageView image = holder.image;
        TextView title = holder.title;
        TextView genre = holder.genre;

        Movie movie = items.get(position);

        image.setImageResource(movie.resId);
        title.setText(movie.title);
        genre.setText(movie.genre);

        Intent intent = new Intent();

        return convertView;
    }
}
