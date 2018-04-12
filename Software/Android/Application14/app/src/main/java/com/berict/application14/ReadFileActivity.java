package com.berict.application14;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        TextView textView = findViewById(R.id.fileResult);

        File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile() + "/example/file.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((file))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
            StringBuffer buffer = new StringBuffer();
            String line;

            buffer.append("[" + file.getAbsolutePath().toString() + "]\n\n");

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            textView.setText(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((buffer.toString())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
