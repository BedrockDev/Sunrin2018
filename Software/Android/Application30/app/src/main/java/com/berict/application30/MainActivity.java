package com.berict.application30;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Movie> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new Movie("Search", "Drama", R.drawable.movie1));
        items.add(new Movie("너의 결혼식", "Romance", R.drawable.movie2));
        items.add(new Movie("신과 함께", "Fantasy", R.drawable.movie3));

        listView = findViewById(R.id.listview);

        listView.setAdapter(new MovieAdapter(this, R.layout.item, items));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = view.findViewById(R.id.imageView);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));

                startActivity(intent, options.toBundle());
            }
        });
    }
}
