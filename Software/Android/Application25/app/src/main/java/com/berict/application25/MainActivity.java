package com.berict.application25;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    ArrayList<String> datas;
    ArrayAdapter<String> adapter;

    Button detailBtn;
    Button dialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_list);
        detailBtn = findViewById(R.id.main_btn_detail);
        dialogBtn = findViewById(R.id.main_btn_dialog);

        detailBtn.setOnClickListener(this);
        dialogBtn.setOnClickListener(this);

        datas = new ArrayList<>();

        datas.add("onCreate....");

        adapter = new ArrayAdapter<>(this, R.layout.item_main_list, datas);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v == detailBtn) {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        } else if (v == dialogBtn) {
            Intent intent = new Intent(this, DialogActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        datas.add("onResume....");
        adapter.notifyDataSetChanged();

        ImageView imageView = new ImageView(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        imageView.setImageResource(R.mipmap.ic_launcher);
//        setContentView(R.layout.activity_main);
//        addContentView(imageView, params);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        datas.add("onSaveInstanceState....");
        adapter.notifyDataSetChanged();

        outState.putString("data1", "hello");
        outState.putInt("data2", 100);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        datas.add("onRestoreInstanceState....");
        adapter.notifyDataSetChanged();

        String data1 = savedInstanceState.getString("data1");
        int data2 = savedInstanceState.getInt("data2");

        Toast.makeText(this, data1 + " / " + data2, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        datas.add("onPause....");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();

        datas.add("onStart....");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStop() {
        super.onStop();

        datas.add("onStop....");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        datas.add("onRestart....");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        datas.add("onDestroy....");
        adapter.notifyDataSetChanged();
    }


}
