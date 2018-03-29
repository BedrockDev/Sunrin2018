package com.berict.example;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    AppCompatActivity activity = this;

    TextView departCity;
    TextView departDate;

    TextView arriveCity;
    TextView arriveDate;

    LinearLayout count;
    TextView countAdult;
    TextView countTeen;
    TextView countChild;

    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        departCity = findViewById(R.id.depart_city);
        departDate = findViewById(R.id.depart_date);
        arriveCity = findViewById(R.id.arrive_city);
        arriveDate = findViewById(R.id.arrive_date);
        count = findViewById(R.id.count);
        countAdult = findViewById(R.id.count_adult);
        countTeen = findViewById(R.id.count_teen);
        countChild = findViewById(R.id.count_child);
        search = findViewById(R.id.search);

        departCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChoiceDialog("Select departing city", departCity, R.array.depart);
            }
        });

        arriveCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChoiceDialog("Select arriving city", arriveCity, R.array.arrive);
            }
        });

        departDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(departDate);
            }
        });

        arriveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(arriveDate);
            }
        });

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                AlertDialog alertDialog;

                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.dialog_count, null);

                builder.setView(customView);

                final EditText num1 = customView.findViewById(R.id.num1);
                final EditText num2 = customView.findViewById(R.id.num2);
                final EditText num3 = customView.findViewById(R.id.num3);

                builder.setPositiveButton("Select", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String n1 = num1.getText().toString();
                        String n2 = num2.getText().toString();
                        String n3 = num3.getText().toString();

                        countAdult.setText("Adult: " + n1);
                        countTeen.setText("Teen: " + n2);
                        countChild.setText("Child: " + n3);
                    }
                });

                builder.setNegativeButton("Close", null);

                alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    void showChoiceDialog(String title, final TextView textView, int res) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog;

        final String items[] = getResources().getStringArray(res);

        builder.setTitle(title);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textView.setText(items[i]);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
    }

    void showDateDialog(final TextView textView) {
        DatePickerDialog dateDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        textView.setText(i + "/" + (i1 + 1) + "/" + i2);
                    }
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        dateDialog.show();
    }
}
