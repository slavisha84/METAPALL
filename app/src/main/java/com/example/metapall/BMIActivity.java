package com.example.metapall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BMIActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private EditText age;
    private EditText sex;
    private TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        age = (EditText) findViewById(R.id.age);
        sex = (EditText) findViewById(R.id.sex);
        result = (TextView) findViewById(R.id.result);

    }
    public void CalculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)&& weightStr != null && !"".equals(weightStr)) {
            double heightValue = Double.parseDouble(heightStr);
            double weightValue = Double.parseDouble(weightStr);

            double bmi = Math.round(((weightValue * 703) / (heightValue*heightValue))*100);
            result.setText("YOUR BMI IS: " + bmi/100);
        }
    }
}