package com.example.metapall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*******************************************************************************************
         * Locating buttons by its ID within Activity_main.xml and assigning them
         *******************************************************************************************/

        Button buttonProg = findViewById(R.id.buttonProg);
        Button buttonReci = findViewById(R.id.buttonReci);
        Button buttonBmr = findViewById(R.id.buttonBmr);
        Button buttonH2o = findViewById(R.id.buttonH2o);
        Button buttonCho = findViewById(R.id.buttonCho);
        Button buttonPro = findViewById(R.id.buttonPro);
        Button buttonCal = findViewById(R.id.buttonCal);
        Button buttonSet = findViewById(R.id.buttonSet);

        buttonProg.setOnClickListener(this);
        buttonReci.setOnClickListener(this);
        buttonBmr.setOnClickListener(this);
        buttonH2o.setOnClickListener(this);
        buttonCho.setOnClickListener(this);
        buttonPro.setOnClickListener(this);
        buttonCal.setOnClickListener(this);
        buttonSet.setOnClickListener(this);
    }

    /*******************************************************************************************
     * Setting up Onclick method to switch between each element in cardView of Activity_main.xml
     *******************************************************************************************/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonProg:
                openProgressActivity();
                break;
            case R.id.buttonReci:
                openReciActivity();
                break;
            case R.id.buttonBmr:
                openBMRActivity();
                break;
            case R.id.buttonH2o:
                openH2OActivity();
                break;
            case R.id.buttonCho:
                openCHOActivity();
                break;
            case R.id.buttonPro:
                openProteinActivity();
                break;
            case R.id.buttonCal:
                openCalendarActivity();
                break;
            case R.id.buttonSet:
                openSettingsActivity();
                break;
        }
    }

    /************************************************************************************
     * Setting Up method to open ProgressActivity
     ************************************************************************************/
    private void openProgressActivity() {
        Intent intent = new Intent(this, ProgActivity.class);
        startActivity(intent);
    }

    /************************************************************************************
     * Setting Up method to open ProgressActivity
     ************************************************************************************/
    private void openReciActivity() {
        Intent intent = new Intent(this, ReciActivity.class);
        startActivity(intent);
    }

    /************************************************************************************
     * Setting Up method to open BMIActivity
     ************************************************************************************/
    private void openBMRActivity() {
        Intent intent = new Intent(this, BMRActivity.class);
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

