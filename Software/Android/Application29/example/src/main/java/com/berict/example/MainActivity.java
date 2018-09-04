package com.berict.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CountView countView;
    View barView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countView = findViewById(R.id.custom);
        barView = findViewById(R.id.barView);

        countView.setOnCountChangedListener(new OnCountChangedListener() {
            @Override
            public void onChange(int value) {
                if (value < 0) {
                    barView.setBackgroundColor(Color.RED);
                } else if (value < 2) {
                    barView.setBackgroundColor(Color.YELLOW);
                } else if (value < 4) {
                    barView.setBackgroundColor(Color.GREEN);
                } else if (value < 6) {
                    barView.setBackgroundColor(Color.BLUE);
                } else if (value < 8) {
                    barView.setBackgroundColor(Color.BLACK);
                } else {
                    barView.setBackgroundColor(Color.CYAN);
                }
            }
        });
    }
}
