package com.berict.application16;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username, password;
    CheckBox check;

    SharedPreferences prefs;

    String loginId;
    Boolean checkValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        check = findViewById(R.id.remember_username);

        prefs = getSharedPreferences("Prefs", MODE_PRIVATE);
        loginId = prefs.getString("loginId", "");
        checkValue = prefs.getBoolean("check", false);

        username.setText(loginId);
        check.setChecked(checkValue);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();

                if (check.isChecked()) {
                    loginId = username.getText().toString();
                    editor.putString("loginId", loginId);
                    editor.putBoolean("check", true);

                    Toast.makeText(getApplicationContext(), "Saved in SharedPrefs", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("loginId", "");
                    editor.putBoolean("check", false);
                }

                editor.commit();
            }
        });
    }
}
