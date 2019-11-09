package com.example.metapall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import org.w3c.dom.Text;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class BMRActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private EditText age;
    private EditText sex;
    private TextView result1;
    private TextView result2;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        age = (EditText) findViewById(R.id.age);
        sex = (EditText) findViewById(R.id.sex);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
        spinner = (Spinner) findViewById(R.id.actlvl);
        spinner.setOnItemSelectedListener(new ItemSelectedListener());


    }

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(spinner.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner.getSelectedItem()))) {

            } else {
                String item = parent.getItemAtPosition(pos).toString();

            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {

        }

    public void CalculateBMR(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        String sexStr = sex.getText().toString();
        String ageStr = age.getText().toString();
        String actItemStr = firstItem;



        if (heightStr != null && !"".equals(heightStr)&& weightStr != null && !"".equals(weightStr) && sexStr !=null && !"".equals(sexStr) && ageStr != null && !"".equals(ageStr) ){
            double heightValue = Double.parseDouble(heightStr);
            double weightValue = Double.parseDouble(weightStr);
            double ageValue = Double.parseDouble(ageStr);

            if (sexStr .equals("M"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) + 5) * 100);
                double bmrr = bmr / 100;
                result1.setText("YOUR BMR IS: " + bmrr);
                if (actItemStr .equals("Light")) {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (actItemStr .equals("Moderate")) {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }

            }

            else if (sexStr .equals("F"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) - 161) * 100);
                double bmrr = bmr / 100;
                double dtee = Math.round((bmrr * 1.53) * 100);
                result1.setText("YOUR BMR IS: " + bmrr);
                result2.setText("YOUR DTEE IS: " + dtee / 100);
            }

            }
    }


}}
