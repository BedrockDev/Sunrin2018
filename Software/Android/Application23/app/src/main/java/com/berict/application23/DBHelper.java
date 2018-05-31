package com.berict.application23;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 7;

    public DBHelper(Context context) {
        super(context, "datadb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SimpleAdapter, CusrsorAdapter Test
        String tableSql = "create table tb_data (" +
                "_id integer primary key autoincrement," +
                "name not null)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_data (name) values ('')");
        db.execSQL("insert into tb_data (name) values ('')");
        db.execSQL("insert into tb_data (name) values ('')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_data");
            onCreate(db);
        }
    }
}