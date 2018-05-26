package com.berict.application22;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    boolean show = true;
    int icon = 0;
    boolean subtitle = false;
    boolean back = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show == true) {
                    actionBar.hide();
                    ((Button) findViewById(R.id.button1)).setText("Show ActionBar");
                    show = false;
                } else {
                    actionBar.show();
                    ((Button) findViewById(R.id.button1)).setText("Hide ActionBar");
                    show = true;
                }
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (icon == 0) {
                    // below defaults to false
                    actionBar.setDisplayShowHomeEnabled(true);
                    actionBar.setIcon(R.drawable.ic_cloud_black_24dp);
                    ((Button) findViewById(R.id.button2)).setText("Next icon");
                    icon = 1;
                } else if (icon == 1) {
                    actionBar.setIcon(R.drawable.ic_cloud_done_black_24dp);
                    ((Button) findViewById(R.id.button2)).setText("Hide icon");
                    icon = 2;
                } else {
                    actionBar.setDisplayShowHomeEnabled(false);
                    actionBar.setIcon(null);
                    ((Button) findViewById(R.id.button2)).setText("Add icon");
                    icon = 0;
                }
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subtitle == true) {
                    actionBar.setSubtitle(null);
                    ((Button) findViewById(R.id.button3)).setText("Hide subtitle");
                    subtitle = false;
                } else {
                    actionBar.setSubtitle("Custom subtitle");
                    ((Button) findViewById(R.id.button3)).setText("Add subtitle");
                    subtitle = true;
                }
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (back == true) {
                    actionBar.setDisplayHomeAsUpEnabled(true);
                    ((Button) findViewById(R.id.button4)).setText("Hide back icon");
                    back = false;
                } else {
                    actionBar.setDisplayHomeAsUpEnabled(false);
                    ((Button) findViewById(R.id.button4)).setText("Add back icon");
                    back = true;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Back clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
