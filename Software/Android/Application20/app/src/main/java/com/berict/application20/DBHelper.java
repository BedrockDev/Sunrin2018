package com.berict.application20;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;

    public DBHelper(Context context) {
        super(context, "calldb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "create table tb_calllog (" +
                "_id integer primary key autoincrement," +
                "name not null," +
                "photo," +
                "date," +
                "phone)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Marylyn Dew','yes','1','288-151-7572')");
        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Faith Fulk','no','1','332-126-6460')");
        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Narcisa Kravetz','no','2','695-728-6721')");
        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Keitha Lubin','yes','2','774-879-8465')");
        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Nobuko Gerhardt','no','2','590-703-2657')");
        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Samella Budde','yes','3','242-795-0147')");
        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Lolita Korus','no','3','376-439-7520')");
        db.execSQL("insert into tb_calllog (name, photo, date, phone) values ('Willetta Hartig','no','3','860-641-3009')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion == DATABASE_VERSION) {
            db.execSQL("drop table tb_calllog");
            onCreate(db);
        }
    }
}