package com.berict.application12;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button db;
    Button table;
    Button insert;
    Button find;

    EditText inputDB;
    EditText inputTable;

    TextView text;

    String dbName, tableName;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = findViewById(R.id.button_db);
        table = findViewById(R.id.button_table);
        insert = findViewById(R.id.button_insert);
        find = findViewById(R.id.button_find);

        inputDB = findViewById(R.id.input_db);
        inputTable = findViewById(R.id.input_table);

        text = findViewById(R.id.text);

        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbName = inputDB.getText().toString();
                createDB();
            }
        });

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = inputTable.getText().toString();
                createTable();
            }
        });
    }

    void createDB() {
        // create the database
        database = openOrCreateDatabase(dbName, MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
        log("Created database [" + dbName + "]");
    }

    void createTable() {
        if (database != null) {
            database.execSQL("CREATE TABLE " + tableName +
                    "( _id integer primary key autoincrement," +
                    "name text," +
                    "age integer," +
                    "phone text);");

            log("Created table [" + tableName + "]");
        } else {
            log("null database");
        }
    }

    void log(String s) {
        text.setText(s + "\n" + text.getText().toString());
    }
}
