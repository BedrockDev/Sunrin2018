package com.berict.application18;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView arrayList;
    ListView simpleList;
    ListView cursorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = findViewById(R.id.list_array);
        simpleList = findViewById(R.id.list_simple);
        cursorList = findViewById(R.id.list_cursor);

        String arrayData[] = {"Seoul", "Tokyo", "New York", "Paris", "Berlin"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                arrayData
        );
        arrayList.setAdapter(arrayAdapter);
        arrayList.setOnItemClickListener(this);

        // 
        ArrayList<HashMap<String, String>> simpleData = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("num", "1");
        map.put("name", "Michael");
        map.put("message", "Lorem Ipsum");
        simpleData.add(map);
        map = new HashMap<>();
        map.put("num", "2");
        map.put("name", "Trevor");
        map.put("message", "Lorem Ipsum");
        simpleData.add(map);
        map = new HashMap<>();
        map.put("num", "3");
        map.put("name", "Franklin");
        map.put("message", "Lorem Ipsum");
        simpleData.add(map);

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                simpleData,
                R.layout.adapter_simple,
                new String[]{"num", "name", "message"},
                new int[]{R.id.text1, R.id.text2, R.id.text3}
        );
        simpleList.setAdapter(simpleAdapter);
        simpleList.setOnItemClickListener(this);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_data", null);

        CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{"name", "content"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );
        cursorList.setAdapter(cursorAdapter);
        cursorList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView == arrayList) {
            Toast.makeText(this, "ArrayList[" + i + "]", Toast.LENGTH_SHORT).show();
        }
        if (adapterView == simpleList) {
            Toast.makeText(this, "SimpleList[" + i + "]", Toast.LENGTH_SHORT).show();
        }
        if (adapterView == cursorList) {
            Toast.makeText(this, "CursorList[" + i + "]", Toast.LENGTH_SHORT).show();
        }
    }
}
