package com.example.metapall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridLayout mainGrid;

    /*******************************************************************************************
    * Setting up onClickListener while locating view by their id in activity_main.xml
     *******************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        findViewById(R.id.cvBMI).setOnClickListener(this);
        findViewById(R.id.cvCHO).setOnClickListener(this);
        findViewById(R.id.cvH2O).setOnClickListener(this);
        findViewById(R.id.cvProtein).setOnClickListener(this);
        findViewById(R.id.cvCalendar).setOnClickListener(this);
        findViewById(R.id.cvSettings).setOnClickListener(this);
    }

    /*******************************************************************************************
     * Setting up Onclick method to switch between each element in cardView of Activity_main.xml
     *******************************************************************************************/

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cvBMI:
                openBMIActivity();
                break;
            case R.id.cvCHO:
                openCHOActivity();
                break;
            case R.id.cvH2O:
                openH2OActivity();
                break;
            case R.id.cvProtein:
                openProteinActivity();
                break;
            case R.id.cvCalendar:
                openCalendarActivity();
                break;
            case R.id.cvSettings:
                openSettingsActivity();
                break;
        }
    }

    /************************************************************************************
     * Setting Up method to open BMIActivity
     ************************************************************************************/
    private void openBMIActivity() {
        Intent intent = new Intent(this, BMIActivity.class);
        startActivity(intent);
    }

    /************************************************************************************
     ** Setting Up method to open CHOActivity
     ************************************************************************************/

    private void openCHOActivity() {
        Intent intent = new Intent(this, CHOActivity.class);
        startActivity(intent);
    }

    /************************************************************************************
     *
     ************************************************************************************/
    private void openH2OActivity() {
        Intent intent = new Intent(this, H2OActivity.class);
        startActivity(intent);
    }

    /************************************************************************************
     *
     ************************************************************************************/
    private void openProteinActivity() {
        Intent intent = new Intent(this, ProteinActivity.class);
        startActivity(intent);
    }

    /************************************************************************************
     *
     ************************************************************************************/
    private void openCalendarActivity() {
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    /************************************************************************************
     *
     ************************************************************************************/
    private void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}

