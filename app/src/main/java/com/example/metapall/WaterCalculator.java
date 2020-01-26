package com.example.metapall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WaterCalculator extends AppCompatActivity {


    private EditText preweight;
    private EditText fluids;
    private EditText postweight;
    private EditText workouttime;
    private TextView pre4h;
    private TextView pre2h;
    private TextView SweatRate;
    private TextView postworkoutres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_calculator);

        preweight = (EditText) findViewById(R.id.preweight);
        fluids = (EditText) findViewById(R.id.fluids);
        postweight = (EditText) findViewById(R.id.postweight);
        workouttime = (EditText) findViewById(R.id.workouttime);

        pre4h = (TextView) findViewById(R.id.pre4h);
        pre2h = (TextView) findViewById(R.id.pre2h);
        SweatRate = (TextView) findViewById(R.id.SweatRate);
        postworkoutres = (TextView) findViewById(R.id.postworkoutres);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.NaviBot);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navhome:
                        Intent a = new Intent(WaterCalculator.this,BMRActivity.class);
                        startActivity(a);
                        break;
                    case R.id.navprofile:
                        Intent b = new Intent(WaterCalculator.this,DashboardActivity.class);
                        startActivity(b);
                        break;
                    case R.id.navcalendar:
                        Intent c = new Intent(WaterCalculator.this,CalendarActivity.class);
                        startActivity(c);
                        break;
                    case R.id.navwater:
                        Intent d = new Intent(WaterCalculator.this,WaterCalculator.class);
                        startActivity(d);
                        break;
                }
                return false;
            }
        });
    }


    public void Calculateh2o(View v){
        String PreWeight = preweight.getText().toString();
        String Fluids = fluids.getText().toString();
        String PostWeight = postweight.getText().toString();
        String WorkoutTime = workouttime.getText().toString();

        if (PreWeight != null && !"".equals(PreWeight)&& Fluids != null && !"".equals(Fluids) && PostWeight != null && !"".equals(PostWeight) && WorkoutTime != null && !"".equals(WorkoutTime)) {
            double PREWEIGHT = Double.parseDouble(PreWeight);
            double FLUID = Double.parseDouble(Fluids);
            double POSTWORKOUT = Double.parseDouble(PostWeight);
            double WORKOUTTIME = Double.parseDouble(WorkoutTime);

            double pre4hres = Math.round(((PREWEIGHT / 2.2) * 5) * 100);
            double pre4hresrnd = pre4hres / 100;
            pre4h.setText("4h Preworkout Results:" + pre4hresrnd);

            double pre2hres = Math.round(((PREWEIGHT /2.2)  * 3) * 100);
            double pre2hresrnd = pre2hres / 100;
            pre2h.setText("2h Preworkout Results:" + pre2hresrnd);

        // Post workout

            double postworkout = Math.round(((PREWEIGHT - POSTWORKOUT) * 16)*100);
            double postworkoutrnd = postworkout / 100;
            postworkoutres.setText("Postworkout Fluid Intake:" + postworkoutrnd);
        // Sweat ratio
            double sweat = Math.round((((PREWEIGHT - POSTWORKOUT) + (FLUID/33.8))/WORKOUTTIME) * 100);
            double sweatres = sweat / 100;
            SweatRate.setText("Sweat Rate: " + sweatres);
        }

        else
            {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            }



    }
}
