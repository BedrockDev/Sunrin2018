package com.berict.application13;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ReadDBActivity extends AppCompatActivity {

    TextView part, id, name, phone, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

        part = findViewById(R.id.part);
        id = findViewById(R.id.num);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + helper.TABLE_NAME + " order by _id desc limit 1", null);
        cursor.moveToNext();

        part.setText(cursor.getString(1));
        id.setText(cursor.getString(2));
        name.setText(cursor.getString(3));
        phone.setText(cursor.getString(4));
        address.setText(cursor.getString(5));
    }
}
