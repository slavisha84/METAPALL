package com.example.metapall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.widget.CalendarView;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.CalendarView;


public class CalendarActivity extends AppCompatActivity {
    private  static final String TAG = "CalendarActivity";
    CalendarView calender;
    TextView date_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calender = (CalendarView)
                findViewById(R.id.calendar);

        // Add Listener in calendar
        calender
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;
                                date_view.setText(Date);

                                // set this date in TextView for Display

                            }
                        });


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.NaviBot);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navhome:
                        Intent a = new Intent(CalendarActivity.this,BMRActivity.class);
                        startActivity(a);
                        break;
                    case R.id.navprofile:
                        Intent b = new Intent(CalendarActivity.this,DashboardActivity.class);
                        startActivity(b);
                        break;

                    case R.id.navwater:
                        Intent c = new Intent(CalendarActivity.this,WaterCalculator.class);
                        startActivity(c);
                        break;
                    case R.id.navcalendar:
                        Intent d = new Intent(CalendarActivity.this,CalendarActivity.class);
                        startActivity(d);
                        break;

                }
                return false;
            }
        });
    }
}
