package com.berict.application9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class TouchEventActivity extends AppCompatActivity {

    TextView log;
    GestureDetector detector;
    float downX;
    float downY;
    float upX;
    float upY;
    long initTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        log = findViewById(R.id.text);

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                log("onDown");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                log("onShowPress");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                log("onSingleTapUp");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                log("onScroll");
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                log("onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                log("onFling");
                return true;
            }
        });

        detector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);

        int action = event.getAction();
        float curX = event.getX();
        float curY = event.getY();

        if (action == MotionEvent.ACTION_DOWN) {
            log("Action Down [" + curX + ", " + curY + "]");

            setDown(event);
        } else if (action == MotionEvent.ACTION_MOVE) {
            log("Action Move [" + curX + ", " + curY + "]");
        } else if (action == MotionEvent.ACTION_UP) {
            log("Action Up   [" + curX + ", " + curY + "]");

            setUp(event);
            log("Move [" + dx() + ", " + dy() + "]");

            if (dy() / dx() > 0) {
                log("Positive");
            } else {
                log("Negative");
            }
        }
        return true;
    }

    void log(String text) {
        log.setText(text + "\n" + log.getText());
    }

    void setDown(MotionEvent event) {
        downX = event.getX();
        downY = event.getY();
    }

    void setUp(MotionEvent event) {
        upX = event.getX();
        upY = event.getY();
    }

    float dy() {
        return -(upY - downY);
    }

    float dx() {
        return upX - downX;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {
                initTime = System.currentTimeMillis();
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            } else {
                finish();
            }
        }
        return true;
    }
}
