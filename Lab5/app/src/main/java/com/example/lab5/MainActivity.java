package com.example.lab5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static int ghour, gminute, gyear, gmonth, gday;
    public static boolean isTatkal = false;
    public static String gfrom, gto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton tb = findViewById(R.id.toggleButton);
        tb.setTextOn("General");
        tb.setTextOff("Tatkal");
        tb.setChecked(false);

        Spinner sp1 = findViewById(R.id.spinner);
        Spinner sp2 = findViewById(R.id.spinner2);

        String[] from = {
                "Mumbai",
                "Delhi"
        };

        String[] to = {
                "Munich",
                "Zagreb"
        };

        ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, from);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> toAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, to);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp1.setAdapter(fromAdapter);
        sp2.setAdapter(toAdapter);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            gyear = year;
            gmonth = month;
            gday = dayOfMonth;
        }
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute, true);
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            ghour = hourOfDay;
            gminute = minute;
        }
    }

    public void clearDateTime(View v) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        ghour = hour;
        gminute = minute;
        gyear = year;
        gmonth = month;
        gday = day;
        Toast.makeText(MainActivity.this, "date and time reset", Toast.LENGTH_SHORT).show();
    }

    public void toggleTatkal(View v) {
        isTatkal = !isTatkal;
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        Button bt = findViewById(R.id.button3);
        if (isTatkal && hour < 11) {
            bt.setEnabled(false);
        } else if (isTatkal && hour > 11) {
            bt.setEnabled(true);
        } else if (!isTatkal) {
            bt.setEnabled(true);
        }
    }

    public void submitInfo(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("hour", ghour);
        intent.putExtra("minute", gminute);
        intent.putExtra("year", gyear);
        intent.putExtra("month", gmonth);
        intent.putExtra("day", gday);
        intent.putExtra("from", gfrom);
        intent.putExtra("to", gto);
        startActivity(intent);
    }
}