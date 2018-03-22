package com.berict.application7;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // an alternative way to do this:
        //setContentView(R.layout.activity_main);

//        LinearLayout linear = new LinearLayout(this);
//        linear.setOrientation(LinearLayout.VERTICAL);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        );
//
//        TextView text = new TextView(this);
//        text.setText("Hello World!!");
//        text.setTextSize(24);
//        text.setTextColor(Color.BLUE);
//
//        linear.addView(text);
//
//        setContentView(linear);

        // inflate a custom layout
        setContentView(R.layout.activity_main);

        sub = findViewById(R.id.sub);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub, sub, true);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // also can access the views in sub layout
                        ((TextView) findViewById(R.id.sub_text)).setText("Loaded");
                    }
                }, 1000);
            }
        });
    }
}
