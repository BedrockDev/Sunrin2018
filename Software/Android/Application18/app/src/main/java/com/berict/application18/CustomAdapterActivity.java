package com.berict.application18;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomAdapterActivity extends AppCompatActivity {

    ListView customList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        customList = findViewById(R.id.list_custom);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_drive", null);

        ArrayList<DriveVO> data = new ArrayList<>();

        while (cursor.moveToNext()) {
            DriveVO vo = new DriveVO();
            vo.title = cursor.getString(1);
            vo.date = cursor.getString(2);
            vo.type = cursor.getString(3);
            data.add(vo);
        }

        db.close();

        DriveAdapter adapter = new DriveAdapter(this, R.layout.adapter_custom, data);
        customList.setAdapter(adapter);
    }
}
