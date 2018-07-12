package com.berict.application27;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent login = getIntent();
        ((TextView) findViewById(R.id.welcome)).setText("Welcome, " + login.getStringExtra("username").toString());

        findViewById(R.id.button1).setOnClickListener(intent);
        findViewById(R.id.button2).setOnClickListener(intent);
        findViewById(R.id.button3).setOnClickListener(intent);

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    View.OnClickListener intent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("title", ((Button) v).getText());
            startActivityForResult(intent, 420);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 420 && resultCode == RESULT_OK) {
            ((TextView) findViewById(R.id.result)).setText("Selected " + data.getStringExtra("title"));
        }
    }
}
