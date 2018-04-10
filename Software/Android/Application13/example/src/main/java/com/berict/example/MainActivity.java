package com.berict.example;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText title, artist, lyric, search;
    Button fillButton, saveButton, searchButton;
    TextView titleText, artistText, lyricText;

    AppCompatActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.input_title);
        artist = findViewById(R.id.input_artist);
        lyric = findViewById(R.id.input_lyric);
        search = findViewById(R.id.input_search);

        fillButton = findViewById(R.id.fill);
        saveButton = findViewById(R.id.save);
        searchButton = findViewById(R.id.search);

        titleText = findViewById(R.id.text_title);
        artistText = findViewById(R.id.text_artist);
        lyricText = findViewById(R.id.text_lyric);

        TabHost host = findViewById(R.id.host);
        host.setup();

        TabHost.TabSpec spec;
        spec = host.newTabSpec("tab1");
        spec.setIndicator("Submit"); // the real tab name
        spec.setContent(R.id.tab_content1);

        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator("Search"); // the real tab name
        spec.setContent(R.id.tab_content2);

        host.addTab(spec);

        for (int i = 0; i < host.getTabWidget().getChildCount(); i++) {
            TextView tv = host.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(getResources().getColor(android.R.color.white));
        }

        fillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setText("Lorem Ipsum");
                artist.setText("Latin");
                lyric.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris gravida turpis semper erat rhoncus, sed rutrum erat malesuada. Fusce sagittis accumsan fringilla. In tempus molestie diam, eu commodo ipsum dictum et. In at cursus turpis. Vivamus porta ornare tellus, et tempor nibh euismod sit amet. Sed rutrum risus lacus, vel auctor augue placerat at. Maecenas id arcu nulla. Cras justo nulla, efficitur eu nunc at, pharetra placerat lacus. In lorem nibh, pretium vitae arcu quis, vulputate sagittis tortor.");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRecord();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = search.getText().toString();

                DBHelper helper = new DBHelper(activity);
                SQLiteDatabase db = helper.getReadableDatabase();

                Cursor cursor = db.rawQuery("SELECT * FROM " + helper.TABLE_NAME + " where title = '" + query + "'", null);
                cursor.moveToNext();

                titleText.setText(cursor.getString(1));
                artistText.setText(cursor.getString(2));
                lyricText.setText(cursor.getString(3));
            }
        });
    }

    void insertRecord() {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("INSERT INTO " + helper.TABLE_NAME + "(title, artist, lyric) values('" +
                title.getText().toString() + "', '" +
                artist.getText().toString() + "', '" +
                lyric.getText().toString() + "')");

        db.close();
    }
}
