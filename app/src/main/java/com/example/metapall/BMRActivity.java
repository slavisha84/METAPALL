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


public class BMRActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    private EditText height;
    private EditText weight;
    private EditText age;
    private EditText gender;
    private TextView result1;
    private TextView result2;
    private Spinner Gspinner;
    private Spinner Aspinner;

    private EditText ActvCh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        age = (EditText) findViewById(R.id.age);
        gender = (EditText) findViewById(R.id.sex);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
        ActvCh = (EditText) findViewById(R.id.ActvCh);

        //find spinner's view
        Gspinner = (Spinner) findViewById(R.id.spinnerGender);
        Aspinner = (Spinner) findViewById(R.id.spinnerActivity);
        //add on item selected listerners to spinner
        Gspinner.setOnItemSelectedListener(this);
        Aspinner.setOnItemSelectedListener(this);

        //create adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.GenderChoice, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Activities, android.R.layout.simple_spinner_item);
        //how the spinner will look when it drop downs on click
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //setting adapter to spinner
        Gspinner.setAdapter(adapter);
        Aspinner.setAdapter(adapter2);

    }
    //Do something when the item is selected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView == Gspinner){
            //getting label name of the selected spinner
            String gen = adapterView.getItemAtPosition(i).toString();
            gender.setText(gen);
        }
        else if(adapterView == Aspinner){
            //getting label name of the selected spinner
            String gen = adapterView.getItemAtPosition(i).toString();
            ActvCh.setText(gen);
        }
    }

    //may keep blank
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void CalculateBMR(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        String genStr = gender.getText().toString();
        String ageStr = age.getText().toString();
        String strActv = ActvCh.getText().toString();


        if (heightStr != null && !"".equals(heightStr)&& weightStr != null && !"".equals(weightStr) && genStr !=null && !"".equals(genStr) && ageStr != null && !"".equals(ageStr) ){
            double heightValue = Double.parseDouble(heightStr);
            double weightValue = Double.parseDouble(weightStr);
            double ageValue = Double.parseDouble(ageStr);

            if (genStr .equals("M"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) + 5) * 100);
                double bmrr = bmr / 100;
                result1.setText("YOUR BMR IS: " + bmrr);
                if (strActv .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (strActv .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (strActv .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }

            }

            else if (genStr .equals("F"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) - 161) * 100);
                double bmrr = bmr / 100;
                result1.setText("YOUR BMR IS: " + bmrr);
                if (strActv .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (strActv .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (strActv .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
            }
        }
    }
}

