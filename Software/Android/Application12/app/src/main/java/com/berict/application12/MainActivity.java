package com.berict.application12;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button db;
    Button table;
    Button insert;
    Button insertCustom;
    Button find;

    EditText inputDB;
    EditText inputTable;

    TextView text;

    String dbName, tableName;

    SQLiteDatabase database;

    AppCompatActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = findViewById(R.id.button_db);
        table = findViewById(R.id.button_table);
        insert = findViewById(R.id.button_insert);
        insertCustom = findViewById(R.id.button_insert_custom);
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

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertRecord();
            }
        });

        insertCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Custom data");

                LinearLayout layout = new LinearLayout(activity);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setPadding(32, 32, 32, 32);

                final EditText input1 = new EditText(getApplicationContext());
                input1.setInputType(InputType.TYPE_CLASS_TEXT);
                input1.setHint("Name");
                layout.addView(input1);

                final EditText input2 = new EditText(getApplicationContext());
                input2.setInputType(InputType.TYPE_CLASS_NUMBER);
                input2.setHint("00");
                layout.addView(input2);

                final EditText input3 = new EditText(getApplicationContext());
                input3.setInputType(InputType.TYPE_CLASS_TEXT);
                input3.setHint("000-0000-0000");
                layout.addView(input3);

                builder.setView(layout);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s1 = input1.getText().toString();
                        String s2 = input2.getText().toString();
                        String s3 = input3.getText().toString();

                        insertRecord(s1, s2, s3);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectRecord();
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
            database.execSQL("CREATE TABLE IF NOT EXISTS " + tableName +
                    "( _id integer primary key autoincrement," +
                    "name text," +
                    "age integer," +
                    "phone text);");

            log("Created table [" + tableName + "]");
        } else {
            log("null database");
        }
    }

    void insertRecord() {
        String insertSQL = "INSERT INTO " + tableName + "(name, age, phone) values('John', 23, '010-1234-5678');";
        database.execSQL(insertSQL);

        insertSQL = "INSERT INTO " + tableName + "(name, age, phone) values('Mark', 21, '010-2345-5678');";
        database.execSQL(insertSQL);

        insertSQL = "INSERT INTO " + tableName + "(name, age, phone) values('Zucc', 34, '010-7243-6234');";
        database.execSQL(insertSQL);

        log("Example record inserted");
    }

    void insertRecord(String name, String age, String phone) {
        String insertSQL = "INSERT INTO " + tableName + "(name, age, phone) values('"
                + name + "', "
                + age + ", '"
                + phone + "');";
        database.execSQL(insertSQL);

        log("Custom record inserted");
    }

    void selectRecord() {
        String selectSQL = "SELECT * FROM " + tableName;
        Cursor cursor = database.rawQuery(selectSQL, null);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            log("[" + cursor.getString(1) + " / " +
                    cursor.getString(2) + " / " +
                    cursor.getString(3) + "]");
        }
    }

    void log(String s) {
        text.setText(s + "\n" + text.getText().toString());
    }
}
