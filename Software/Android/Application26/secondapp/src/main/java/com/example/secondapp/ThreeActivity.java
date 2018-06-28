package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // startActivity(intent);
                // The android:launchMode="singleTask" works here: new TASK is created

                // gets the intent from the TwoActivity
                Intent intent = getIntent();
                intent.putExtra("result", "this works");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
