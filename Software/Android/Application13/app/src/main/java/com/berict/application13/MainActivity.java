package com.berict.application13;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText part, id, name, phone, address;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        part = findViewById(R.id.part);
        id = findViewById(R.id.num);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        add = findViewById(R.id.add_btn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRecord();
            }
        });
    }

    void insertRecord() {
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("INSERT INTO " + helper.TABLE_NAME + "(part, id, name, phone, address) values('" +
                part.getText().toString() + "', " +
                id.getText().toString() + ", '" +
                name.getText().toString() + "', '" +
                phone.getText().toString() + "', '" +
                address.getText().toString() + "')");

        db.close();

        Intent intent = new Intent(this, ReadDBActivity.class);
        startActivity(intent);
    }
}
