package com.berict.application15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileActivity extends AppCompatActivity {
    TextView fileResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);
        fileResult = (TextView) findViewById(R.id.fileResult);

        //파일 읽어오기
        File file = new File(getFilesDir() + "/myTest/test.txt");

        /* The file is found @ /data/data/com.berict.application15/files/myTest/test.txt
        * The parent folder will be removed on application removal */

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuffer buffer = new StringBuffer();
            String line;
            buffer.append(file.getAbsolutePath().toString() + "\n");
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            fileResult.setText(buffer.toString());
            reader.close();

        } catch (IOException e) {
            Log.e("ReadFileActivity", "파일 읽기 중 오류가 발생했습니다.");
        }
    }
}
