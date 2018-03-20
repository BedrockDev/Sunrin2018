package com.berict.application6;

import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int layout = R.layout.layout_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);

        switch (layout) {
            case R.layout.layout_textview:
                Typeface typeface = Typeface.createFromAsset(getAssets(), "consola.ttf");
                ((TextView)findViewById(R.id.text_long)).setTypeface(typeface);
                break;
            case R.layout.layout_edittext:
                final TextView textLength = findViewById(R.id.edittext_length);

                EditText editText = findViewById(R.id.edittext);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        textLength.setText(charSequence.length() + "/80");
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        // or here
                    }
                });
                break;
            case R.layout.layout_checkbox_radiobutton:
                final Button btn = findViewById(R.id.button);
                final CheckBox check = findViewById(R.id.check);
                final RadioGroup group = findViewById(R.id.group);

                group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int id) {
                        if (id == R.id.radio1) {
                            Toast.makeText(getApplicationContext(), "Selected 1", Toast.LENGTH_SHORT).show();
                        } else if (id == R.id.radio2) {
                            Toast.makeText(getApplicationContext(), "Selected 2", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            check.setText("is Checked");
                        } else {
                            check.setText("is unChecked");
                        }
                    }
                });

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.layout.layout_image:
                BitmapDrawable bitmap = (BitmapDrawable)getResources().getDrawable(R.drawable.image);
                ((TextView)findViewById(R.id.image_size)).setText(bitmap.getIntrinsicWidth() + " X " + bitmap.getIntrinsicHeight());
                break;
        }
    }
}
