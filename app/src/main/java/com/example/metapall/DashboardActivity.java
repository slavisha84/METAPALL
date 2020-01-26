package com.example.metapall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class DashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        String Htext = intent.getStringExtra(BMRActivity.H_TEXT);
        String Wtext = intent.getStringExtra(BMRActivity.W_TEXT);
        String Atext = intent.getStringExtra(BMRActivity.A_TEXT);
        String HRText = intent.getStringExtra(BMRActivity.AHR_TEXT);
        String AHRResl = intent.getStringExtra(BMRActivity.AHRRESULTS);
        String Gtext = intent.getStringExtra(BMRActivity.G_TEXT);
        String ACTtext = intent.getStringExtra(BMRActivity.ACT_TEXT);
        String BRM_RES = intent.getStringExtra(BMRActivity.BMR_R);
        String TDEE_RES = intent.getStringExtra(BMRActivity.TDEE_R);
        String MIN_CHO_RES = intent.getStringExtra(BMRActivity.MinCHO_R);
        String MAX_CHO_RES = intent.getStringExtra(BMRActivity.MaxCHO_R);

        String PRO1 = intent.getStringExtra(BMRActivity.PROT_1);
        String PRO2 = intent.getStringExtra(BMRActivity.PROT_2);
        String PRO3 = intent.getStringExtra(BMRActivity.PROT_3);
        String AHRRES = intent.getStringExtra(BMRActivity.AHR_TEXT);

        TextView HEIGHT = (TextView) findViewById(R.id.HEIGHT);
        TextView WEIGHT = (TextView) findViewById(R.id.WEIGHT);
        TextView AGE = (TextView) findViewById(R.id.AGE);
        TextView GENDER = (TextView) findViewById(R.id.GENDER);
        TextView ACTVLVL = (TextView) findViewById(R.id.ACTLVL);
        TextView BMRResults = (TextView) findViewById(R.id.BMRResults);
        TextView TDEEResults = (TextView) findViewById(R.id.TDEEResults);
        TextView MinCHO = (TextView) findViewById(R.id.MinCHO_RES);
        TextView MaxCHO = (TextView) findViewById(R.id.MaxCHO_RES);
        TextView Pro1 = (TextView) findViewById(R.id.PROTEIN1);
        TextView Pro2 = (TextView) findViewById(R.id.PROTEIN2);
        TextView Pro3 = (TextView) findViewById(R.id.PROTEIN3);
        TextView DAHRRes = (TextView) findViewById(R.id.DAHRRes);
        TextView DAHR = (TextView) findViewById(R.id.DAHR);

        HEIGHT.setText("HEIGHT:           " + Htext + " ft");
        WEIGHT.setText("WEIGHT:           " + Wtext + " lb");
        AGE.setText("AGE:                 " + Atext);
        GENDER.setText("GENDER:          " + Gtext);
        ACTVLVL.setText("ACTIVITY LVL:  " + ACTtext);
        BMRResults.setText(BRM_RES);
        TDEEResults.setText(TDEE_RES);
        MinCHO.setText(MIN_CHO_RES);
        MaxCHO.setText(MAX_CHO_RES);
        Pro1.setText(PRO1);
        Pro2.setText(PRO2);
        Pro3.setText(PRO3);
        DAHR.setText("AVG HR:              " + HRText);
        DAHRRes.setText(AHRResl);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.NaviBot);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navhome:
                        Intent a = new Intent(DashboardActivity.this,BMRActivity.class);
                        startActivity(a);
                        break;
                    case R.id.navprofile:
                        Intent b = new Intent(DashboardActivity.this,DashboardActivity.class);
                        startActivity(b);
                        break;
                    case R.id.navcalendar:
                        Intent c = new Intent(DashboardActivity.this,CalendarActivity.class);
                        startActivity(c);
                        break;
                    case R.id.navwater:
                        Intent d = new Intent(DashboardActivity.this,WaterCalculator.class);
                        startActivity(d);
                        break;
                }
                return false;
            }
        });
    }


}
