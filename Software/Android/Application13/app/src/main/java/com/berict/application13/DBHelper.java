package com.berict.application13;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    static String DB_NAME = "student_db";
    static String TABLE_NAME = "student";
    static int DB_VERSION = 1;
    String TAG = getClass().getName();

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(_id integer primary key autoincrement, " +
                "part text, " +
                "id integer, " +
                "name text, " +
                "phone text, " +
                "address text);";

        try {
            sqLiteDatabase.execSQL(createTable);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }
}
