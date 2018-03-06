package com.example.sunrin.application1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        Intent intent = getIntent();
        String text = intent.getStringExtra("tag");

        ((TextView)findViewById(R.id.text)).setText(text);
    }
}
