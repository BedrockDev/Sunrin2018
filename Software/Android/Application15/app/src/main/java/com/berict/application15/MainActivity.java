package com.berict.application15;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText contentView;
    Button btn;
    //퍼미션 부여 여부 저장 변수
    boolean fileReadPermisstion, fileWritePermisstion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentView = (EditText) findViewById(R.id.content);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //퍼미션 부여되었다면
        try {
            //외부 저장 공간 경로 획득
            String dirPath = getFilesDir() + "/myTest";
            File dir = new File(dirPath);
            //폴더가 없으면 새로 만들어준다
            if (!dir.exists()) {
                dir.mkdir();
            }
            //myApp폴더에 myfile.txt파일 만들기
            File file = new File(dir + "/test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            //파일 저장
            FileWriter writer = new FileWriter(file, true);
            writer.write(contentView.getText().toString());
            writer.flush();
            writer.close();

            //결과 확인을 위한 ReadFileActivity 실행
            Intent intent = new Intent(this, ReadFileActivity.class);
            startActivity(intent);


        } catch (IOException e) {
            Log.e("MainActivity", "파일 생성이 되지 않았습니다.");
        }
    }

}
