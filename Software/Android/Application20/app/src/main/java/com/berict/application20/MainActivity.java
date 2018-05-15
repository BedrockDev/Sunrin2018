package com.berict.application20;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

        ListView list = findViewById(R.id.main_list);
        DBHelper helper = new DBHelper(this);
        final ArrayList<LogItem> data = new ArrayList<>();

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_calllog", null);

        while (cursor.moveToNext()) {
            LogItem item = new LogItem(
                    cursor.getString(1),
                    cursor.getString(2),
                    Integer.valueOf(cursor.getString(3)),
                    cursor.getString(4)
            );

            data.add(item);
        }

        LogAdapter logAdapter = new LogAdapter(this, R.layout.main_list_item, data);
        list.setAdapter(logAdapter);
    }
}
