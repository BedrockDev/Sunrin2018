package com.berict.application7;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText name;
    EditText address;

    RadioGroup age;
    String ageGroup;

    TextView usernameText;
    TextView nameText;
    TextView addressText;
    TextView ageText;
    TextView termsText;

    TextView usernameResult;
    TextView nameResult;
    TextView addressResult;
    TextView ageResult;

    View result;

    CheckBox terms;
    boolean isTermAgree = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.edittext_username);
        name = findViewById(R.id.edittext_name);
        address = findViewById(R.id.edittext_address);
        age = findViewById(R.id.radiogroup_age);
        terms = findViewById(R.id.checkbox_terms);

        usernameText = findViewById(R.id.text_username);
        nameText = findViewById(R.id.text_name);
        addressText = findViewById(R.id.text_address);
        ageText = findViewById(R.id.text_age);
        termsText = findViewById(R.id.text_terms);

        usernameResult = findViewById(R.id.result_username);
        nameResult = findViewById(R.id.result_name);
        addressResult = findViewById(R.id.result_address);
        ageResult = findViewById(R.id.result_age);

        result = findViewById(R.id.result);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                if (length > 8 || length == 0) {
                    username.setTextColor(Color.RED);
                    usernameText.setTextColor(Color.RED);
                } else {
                    username.setTextColor(Color.BLACK);
                    usernameText.setTextColor(Color.BLACK);
                }
            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                if (length == 0) {
                    nameText.setTextColor(Color.RED);
                } else {
                    nameText.setTextColor(Color.BLACK);
                }
            }
        });

        address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                if (length == 0) {
                    addressText.setTextColor(Color.RED);
                } else {
                    addressText.setTextColor(Color.BLACK);
                }
            }
        });

        age.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                ageGroup = ((RadioButton) radioGroup.getChildAt(i - 1)).getText().toString();
                ageText.setTextColor(Color.BLACK);
            }
        });

        findViewById(R.id.layout_terms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terms.toggle();
            }
        });

        terms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isTermAgree = b;
                if (isTermAgree == true) {
                    termsText.setTextColor(Color.BLACK);
                }
            }
        });
    }

    public void save(View v) {
        boolean isFilled = true;

        if (username.getText().toString().length() == 0 || username.getText().toString().length() > 8) {
            usernameText.setTextColor(Color.RED);
            isFilled = false;
        }

        if (name.getText().toString().length() == 0) {
            nameText.setTextColor(Color.RED);
            isFilled = false;
        }

        if (address.getText().toString().length() == 0) {
            addressText.setTextColor(Color.RED);
            isFilled = false;
        }

        if (age.getCheckedRadioButtonId() < 0) {
            ageText.setTextColor(Color.RED);
            isFilled = false;
        }

        if (terms.isChecked() == false) {
            termsText.setTextColor(Color.RED);
            isFilled = false;
        }

        if (isFilled) {
            result.setVisibility(View.VISIBLE);
            usernameResult.setText("Username : " + username.getText().toString());
            nameResult.setText("Name : " + name.getText().toString());
            addressResult.setText("Address : " + address.getText().toString());
            ageResult.setText("Age : " + ageGroup);
        }
    }

    public void close(View v) {
        finish();
    }
}
