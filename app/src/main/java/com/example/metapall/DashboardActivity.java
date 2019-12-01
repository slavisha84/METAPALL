package com.example.metapall;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        String Htext = intent.getStringExtra(BMRActivity.H_TEXT);
        String Wtext = intent.getStringExtra(BMRActivity.W_TEXT);
        String Atext = intent.getStringExtra(BMRActivity.A_TEXT);
        String Gtext = intent.getStringExtra(BMRActivity.G_TEXT);
        String ACTtext = intent.getStringExtra(BMRActivity.ACT_TEXT);


        TextView HEIGHT = (TextView) findViewById(R.id.HEIGHT);
        TextView WEIGHT = (TextView) findViewById(R.id.WEIGHT);
        TextView AGE = (TextView) findViewById(R.id.AGE);
        TextView GENDER = (TextView) findViewById(R.id.GENDER);
        TextView ACTVLVL = (TextView) findViewById(R.id.ACTLVL);


        HEIGHT.setText("HEIGHT:           " + Htext + " ft");
        WEIGHT.setText("WEIGHT:           " + Wtext + " lb");
        AGE.setText("AGE:                 " + Atext);
        GENDER.setText("GENDER:          " + Gtext);
        ACTVLVL.setText("ACTIVITY LVL:  " + ACTtext);

    }
}
