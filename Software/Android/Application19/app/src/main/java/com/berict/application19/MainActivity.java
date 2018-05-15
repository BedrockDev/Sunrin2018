package com.berict.application19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<SingerItem> data;
    SingerAdapter singerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView singerList = findViewById(R.id.singerList);
        Button button = findViewById(R.id.button);

        data = new ArrayList<>();
        data.add(new SingerItem("소녀시대", "010-2233-4456", 9, R.drawable.singer));
        data.add(new SingerItem("여자친구", "010-3344-5566", 6, R.drawable.singer2));
        data.add(new SingerItem("러블리즈", "010-9988-1122", 10, R.drawable.singer3));
        data.add(new SingerItem("우주소녀", "010-4455-1199", 12, R.drawable.singer4));
        data.add(new SingerItem("구구단", "010-3377-8765", 9, R.drawable.singer5));

        singerAdapter = new SingerAdapter(this, R.layout.singer_item, data);
        singerList.setAdapter(singerAdapter);

        singerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (data.get(position)).name;
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                data.remove(position);
                refresh();
            }
        });

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SingerItem item = new SingerItem(((EditText) findViewById(R.id.editText)).getText().toString());
        data.add(item);
        refresh();
    }

    void refresh() {
        singerAdapter.notifyDataSetChanged();
    }
}
