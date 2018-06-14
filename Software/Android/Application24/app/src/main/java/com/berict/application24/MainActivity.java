package com.berict.application24;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button contactsBtn;
    Button cameraDataBtn;
    Button cameraFileBtn;
    Button speechBtn;
    Button mapBtn;
    Button browserBtn;
    Button callBtn;
    Button galleryBtn;

    TextView resultView;
    ImageView resultImageView;

    File filePath;

    int reqWidth;
    int reqHeight;

    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = findViewById(R.id.resultView);
        contactsBtn = findViewById(R.id.btn_contacts);
        cameraDataBtn = findViewById(R.id.btn_camera_data);
        cameraFileBtn = findViewById(R.id.btn_camera_file);
        speechBtn = findViewById(R.id.btn_speech);
        mapBtn = findViewById(R.id.btn_map);
        browserBtn = findViewById(R.id.btn_browser);
        callBtn = findViewById(R.id.btn_call);
        resultImageView = findViewById(R.id.resultImageView);
        galleryBtn = findViewById(R.id.btn_gallery);

        contactsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, 10);
            }
        });

        cameraDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // returns resized bitmap
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 20);
            }
        });

        cameraFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // returns full size file
                if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
                } else {
                    // permission allowed
                    File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/application24");
                    if (!dir.exists()) {
                        dir.mkdir();
                    }
                    try {
                        filePath = File.createTempFile("IMG", ".jpg", dir);

                        Uri photoUri = FileProvider.getUriForFile(activity, "com.berict.application24.provider", filePath);
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(intent, 30);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        resultImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri photoUri = FileProvider.getUriForFile(activity, "com.berict.application24.provider", filePath);
                intent.setDataAndType(photoUri, "image/*");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent);
            }
        });

        speechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        browserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        reqWidth = getResources().getDimensionPixelSize(R.dimen.request_image_width);
//        reqHeight = getResources().getDimensionPixelSize(R.dimen.request_image_height);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_OK) {
            switch (requestCode) {
                case 10:
                    resultView.setText(data.getDataString());
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(ContactsContract.Contacts.CONTENT_URI + "/" + 1));
                    startActivity(intent);
                    break;
                case 20:
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    resultImageView.setImageBitmap(bitmap);
                    break;
                case 30:
                    if (filePath != null) {
                        Bitmap bitmapFile = BitmapFactory.decodeFile(filePath.getAbsolutePath());
                        resultImageView.setImageBitmap(bitmapFile);
                    }
            }
        }
    }
}
