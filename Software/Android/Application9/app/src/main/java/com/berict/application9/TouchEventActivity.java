package com.berict.application9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class TouchEventActivity extends AppCompatActivity {

    TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        log = findViewById(R.id.text);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float curX = event.getX();
        float curY = event.getY();

        if (action == MotionEvent.ACTION_DOWN) {
            log("Action Down [" + curX + ", " + curY + "]");
        } else if (action == MotionEvent.ACTION_MOVE) {
            log("Action Move [" + curX + ", " + curY + "]");
        } else if (action == MotionEvent.ACTION_UP) {
            log("Action Up   [" + curX + ", " + curY + "]");
        }
        return true;
    }

    void log(String text) {
        log.setText(text + "\n" + log.getText());
    }
}
