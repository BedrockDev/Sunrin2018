package com.berict.application25;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    int count;
    TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Button btn = findViewById(R.id.detail_btn);
        countView = findViewById(R.id.detail_count);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        countView.setText(String.valueOf(count));
    }

    @Override
    public void onClick(View v) {
        count++;
        countView.setText(String.valueOf(count));
    }
}
