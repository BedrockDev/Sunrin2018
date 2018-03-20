package com.berict.application5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    int layout = R.layout.activity_frame_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);

        if (layout == R.layout.activity_frame_tab) {
            TabHost host = findViewById(R.id.host);
            host.setup();

            TabHost.TabSpec spec;
            spec = host.newTabSpec("tab1");
            spec.setIndicator("First"); // the real tab name
            spec.setContent(R.id.tab_content1);

            host.addTab(spec);

            spec = host.newTabSpec("tab2");
            spec.setIndicator("Second"); // the real tab name
            spec.setContent(R.id.tab_content2);

            host.addTab(spec);

            spec = host.newTabSpec("tab3");
            spec.setIndicator("Third"); // the real tab name
            spec.setContent(R.id.tab_content3);

            host.addTab(spec);
        }
    }

    public void onImageClicked(View v) {
        v.setVisibility(View.INVISIBLE);
        if (Integer.valueOf(v.getTag().toString()) != 5) {
            findViewById(getId("image" + (Integer.valueOf(v.getTag().toString()) + 1))).setVisibility(View.VISIBLE);
        } else {
            findViewById(getId("image1")).setVisibility(View.VISIBLE);
        }
    }

    public static int getId(String id) {
        try {
            Class res = R.id.class;
            Field field = res.getField(id);
            return field.getInt(null);
        } catch (Exception e) {
            Log.e("getId", "Failure to get id.", e);
            return -1;
        }
        //from : https://daniel-codes.blogspot.com/2009/12/dynamically-retrieving-resources-in.html
    }
}
