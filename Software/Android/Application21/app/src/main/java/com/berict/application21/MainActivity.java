package com.berict.application21;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.spinner_array)
        );
        ((Spinner) findViewById(R.id.spinner)).setAdapter(arrayAdapter);

        //AutocompleteTextView
        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.auto_array)
        );
        ((AutoCompleteTextView) findViewById(R.id.autocomplete)).setAdapter(autoCompleteAdapter);

        //ProgressBar
        progressBar = findViewById(R.id.progressbar);
        progressBar.setProgress(0);
        final ProgressThread thread = new ProgressThread();
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.start();
            }
        });

        //SeekBar
        SeekBar seekBar = findViewById(R.id.seekbar);
        final TextView seekText = findViewById(R.id.seekbar_progress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekText.setText(i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    class ProgressThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < progressBar.getMax(); i++) {
                SystemClock.sleep(5);
                progressBar.incrementProgressBy(1);
                progressBar.incrementSecondaryProgressBy(2);
            }
            super.run();
        }
    }
}
