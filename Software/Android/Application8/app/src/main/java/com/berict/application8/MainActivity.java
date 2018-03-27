package com.berict.application8;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_dialog).setOnClickListener(this);
        findViewById(R.id.button_dialog_list).setOnClickListener(this);
        findViewById(R.id.button_dialog_radio).setOnClickListener(this);
        findViewById(R.id.button_dialog_datepicker).setOnClickListener(this);
        findViewById(R.id.button_dialog_timepicker).setOnClickListener(this);
        findViewById(R.id.button_dialog_custom).setOnClickListener(this);
    }

    int index;

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog;

        if (view.getTag().equals("dialog")) {
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("Alert");
            builder.setMessage("Quit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    toast("text");
                }
            });
            builder.setNegativeButton("No", null);
            builder.setCancelable(false);
        } else if (view.getTag().equals("dialog_list")) {
            final String items[] = new String[]{"First", "Second", "Third"};

            builder.setTitle("Select");
            builder.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    toast("Selected " + items[i]);
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.setCancelable(false);
        } else if (view.getTag().equals("dialog_radio")) {
            builder.setTitle("Select one");
            builder.setSingleChoiceItems(R.array.radio_array, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    index = i;
                }
            });
            builder.setPositiveButton("Select", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String datas[] = getResources().getStringArray(R.array.radio_array);

                    toast("Selected " + datas[index]);
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.setCancelable(false);
        } else if (view.getTag().equals("dialog_datepicker")) {
            builder = null;

            DatePickerDialog dateDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                            toast(i + "/" + (i1 + 1) + "/" + i2);
                        }
                    },
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

            dateDialog.show();
        } else if (view.getTag().equals("dialog_timepicker")) {
            builder = null;

            Calendar c = Calendar.getInstance();

            TimePickerDialog timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    toast(i + ":" + (i1 + 1));
                }
            }, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true);

            timeDialog.show();
        } else if (view.getTag().equals("dialog_custom")) {
            LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View customView = inflater.inflate(R.layout.dialog_custom, null);

            builder.setView(customView);
            final CheckBox check = customView.findViewById(R.id.checkbox);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (check.isChecked()) {
                        toast("Allowed");
                    } else {
                        toast("Disallowed");
                    }
                }
            });

            builder.setNegativeButton("Close", null);
        }

        if (builder != null) {
            alertDialog = builder.create();
            alertDialog.show();
        }
    }

    void toast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
