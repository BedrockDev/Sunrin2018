package com.example.sunrin.application1;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ShortcutManager shortcutManager;

    @RequiresApi(api = 27)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shortcutManager = getSystemService(ShortcutManager.class);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                addShortcut(getEditText(R.id.edittext_short),
                        getEditText(R.id.edittext_long),
                        getEditText(R.id.edittext_id),
                        getEditText(R.id.edittext_long));
            }
        });

        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Removed", Toast.LENGTH_SHORT).show();
                removeShortcut(getEditText(R.id.edittext_id));
            }
        });
    }

    String getEditText(int id) {
        return ((EditText)findViewById(id)).getText().toString();
    }

    @RequiresApi(api = 27)
    void addShortcut(String shortLabel, String longLabel, String id, String intent) {
        Intent mIntent = new Intent(this, IntentActivity.class);
        mIntent.setAction(Intent.ACTION_VIEW);
        mIntent.putExtra("tag", intent);

        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, id)
                .setShortLabel(shortLabel)
                .setLongLabel(longLabel)
                .setIcon(Icon.createWithResource(this, R.drawable.icon))
                .setIntent(mIntent)
                .build();

        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
    }

    @RequiresApi(api = 27)
    void removeShortcut(String id) {
        List<String> idList = new ArrayList<>();
        idList.add(id);

        shortcutManager.removeDynamicShortcuts(idList);
    }
}
