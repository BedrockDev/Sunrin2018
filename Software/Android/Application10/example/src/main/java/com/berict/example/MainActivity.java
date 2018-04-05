package com.berict.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Animation translate;
    Animation rotate;
    Animation scale;
    Animation alpha;

    Button buttonTranslate;
    Button buttonRotate;
    Button buttonScale;
    Button buttonAlpha;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTranslate = findViewById(R.id.button1);
        buttonRotate = findViewById(R.id.button2);
        buttonScale = findViewById(R.id.button3);
        buttonAlpha = findViewById(R.id.button4);

        imageView = findViewById(R.id.imageView);

        buttonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(translate);
            }
        });
        buttonRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(rotate);
            }
        });
        buttonScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(scale);
            }
        });
        buttonAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(alpha);
            }
        });

        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        Animation.AnimationListener listener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "AnimationEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        translate.setAnimationListener(listener);
        rotate.setAnimationListener(listener);
        scale.setAnimationListener(listener);
        alpha.setAnimationListener(listener);
    }
}
