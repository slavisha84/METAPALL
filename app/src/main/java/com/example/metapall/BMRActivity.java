package com.example.metapall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.telephony.SignalStrength;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    public static final String H_TEXT = "com.metaboli.application.metaboli.H_TEXT";
    public static final String W_TEXT = "com.metaboli.application.metaboli.W_TEXT";
    public static final String A_TEXT = "com.metaboli.application.metaboli.A_TEXT";
    public static final String G_TEXT = "com.metaboli.application.metaboli.G_TEXT";
    public static final String ACT_TEXT = "com.metaboli.application.metaboli.ACT_TEXT";
    public static final String BMR_R = "com.metaboli.application.metaboli.BMR_R";
    public static final String TDEE_R = "com.metaboli.application.metaboli.TDEE_R";
    public static final String MinCHO_R = "com.metaboli.application.metaboli.MinCHO_R";
    public static final String MaxCHO_R = "com.metaboli.application.metaboli.MaxCHO_R";
    public static final String PROT_1 = "com.metaboli.application.metaboli.PROT_1";
    public static final String PROT_2 = "com.metaboli.application.metaboli.PROT_2";
    public static final String PROT_3 = "com.metaboli.application.metaboli.PROT_3";

    private EditText height;
    private EditText weight;
    private EditText age;
    private EditText duration;
    private TextView BMRResults;
    private TextView TDEEResults;
    private TextView MinCHOResults;
    private TextView MaxChOResults;
    private TextView PROResults1;
    private TextView PROResults2;
    private TextView PROResults3;
    private Spinner Gspinner;
    private Spinner Aspinner;
    private String genderCh;
    private String ActvCh;

    DatabaseHelper PersonalDB;
    Button btnAddData;

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        age = (EditText) findViewById(R.id.age);
        BMRResults = (TextView) findViewById(R.id.BMRResults);
        TDEEResults = (TextView) findViewById(R.id.TDEEResults);
        MinCHOResults = (TextView) findViewById((R.id.MinCHOResults));
        MaxChOResults = (TextView) findViewById((R.id.MaxCHOResults));
        PROResults1 = (TextView) findViewById(R.id.PROResults1);
        PROResults2 = (TextView) findViewById(R.id.PROResults2);
        PROResults3 = (TextView) findViewById(R.id.PROResults3);
        duration = (EditText)  findViewById(R.id.duration);


        // Use Radiobutton to establish the presence of duration field
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.training){
                    duration.setVisibility(View.VISIBLE);
                } else {
                    duration.setVisibility(View.INVISIBLE);
                }
            }
        });

        //Identify spinners view based on r.id
        Gspinner = (Spinner) findViewById(R.id.spinnerGender);
        Aspinner = (Spinner) findViewById(R.id.spinnerActivity);
        //add on item selected listerners to spinner
        Gspinner.setOnItemSelectedListener(this);
        Aspinner.setOnItemSelectedListener(this);

        btnAddData = (Button) findViewById(R.id.btnAddData);
        PersonalDB = new DatabaseHelper(BMRActivity.this);

        //Construct the adapter with simple spinner item
        ArrayAdapter<CharSequence> Gendapter = ArrayAdapter.createFromResource(this, R.array.GenderChoice, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> Actvadapter = ArrayAdapter.createFromResource(this, R.array.Activities, android.R.layout.simple_spinner_item);

        //Construct the spinner dropdown items
        Gendapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Actvadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set adapter to Gender spinner and Activity Spinner
        Gspinner.setAdapter(Gendapter);
        Aspinner.setAdapter(Actvadapter);

        AddData();

        Button button = (Button) findViewById(R.id.gotodash);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        Button buttonh2o = (Button) findViewById(R.id.gotowater);
        buttonh2o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }

    public void openActivity3(){

        Intent intent = new Intent(this,WaterCalculator.class);
        startActivity(intent);
    }
    public void  openActivity2(){
        EditText Hght = (EditText) findViewById(R.id.height);
        String Height = Hght.getText().toString();

        EditText Wght = (EditText) findViewById(R.id.weight);
        String Weight = Wght.getText().toString();

        EditText Ag = (EditText) findViewById(R.id.age);
        String Age = Ag.getText().toString();

        String Gender = genderCh;
        String ActLvl = ActvCh;

        String bmrres = BMRResults.getText().toString();
        String tdeeres = TDEEResults.getText().toString();
        String minchores = MinCHOResults.getText().toString();
        String maxchores = MaxChOResults.getText().toString();
        String protres1 = PROResults1.getText().toString();
        String protres2 = PROResults2.getText().toString();
        String protres3 = PROResults3.getText().toString();

        Intent intent = new Intent(this,DashboardActivity.class);
        intent.putExtra(H_TEXT,Height);
        intent.putExtra(W_TEXT,Weight);
        intent.putExtra(A_TEXT,Age);
        intent.putExtra(G_TEXT,Gender);
        intent.putExtra(ACT_TEXT,ActLvl);
        intent.putExtra(BMR_R,bmrres);
        intent.putExtra(TDEE_R,tdeeres);
        intent.putExtra(MinCHO_R,minchores);
        intent.putExtra(MaxCHO_R,maxchores);
        intent.putExtra(PROT_1,protres1);
        intent.putExtra(PROT_2,protres2);
        intent.putExtra(PROT_3,protres3);
        startActivity(intent);
    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String HEIGHT = height.getText().toString();
                String WEIGHT = weight.getText().toString();
                String GENDER = genderCh;
                String AGE = age.getText().toString();
                String ACTIVITY = ActvCh;

                boolean insertData = PersonalDB.addData(HEIGHT, WEIGHT, GENDER, AGE, ACTIVITY);
                if (insertData == true){
                    Toast.makeText(BMRActivity.this, "Data Successfully Saved!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(BMRActivity.this, "Something Went Wrong!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //Create on item selected function that will capture selected items from dropdown menu.
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView == Gspinner)
        {
            //get dropdown label from gender spinner
            genderCh = adapterView.getItemAtPosition(i).toString();
        }
        else if(adapterView == Aspinner)
        {
            //get dropdown label from activity spinner
            ActvCh = adapterView.getItemAtPosition(i).toString();
        }
    }

    //If nothing is selected, do nothing.
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    genderCh = "Gender";
    ActvCh = "Activity Level";
    }

    // Create Calculator function to calculate all values
    public void CalculateBMR(View v) {
        String HEIGHT = height.getText().toString();
        String WEIGHT = weight.getText().toString();
        String GENDER = genderCh;
        String AGE = age.getText().toString();
        String ACTIVITY = ActvCh;
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        String ACTYPE = (String) radioButton.getText();
        //Toast.makeText(this, "Selected Radio Button: " + ACTYPE,Toast.LENGTH_SHORT).show();
        String DURATION = duration.getText().toString();

        // if statement to execute if all required values are present
        if (ACTYPE.equals("Training") && HEIGHT != null && !"".equals(HEIGHT)&& WEIGHT != null && !"".equals(WEIGHT) && AGE != null && !"".equals(AGE) && GENDER != "Gender" && !"".equals(GENDER) && ACTIVITY != "Activity Level" && !"".equals(ACTIVITY)){
            double heightValue = Double.parseDouble(HEIGHT);
            double weightValue = Double.parseDouble(WEIGHT);
            double ageValue = Double.parseDouble(AGE);
            double durValue = Double.parseDouble(DURATION);

            // IF statement to provide calculation based on Male gender and one out of 3 level of activity
            if (GENDER .equals("Male"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) + 5) * 100);
                double bmrr = bmr / 100;
                BMRResults.setText("BMR: " + bmrr);

                // Calculate CHO for male based on hour of training
                if (durValue <= 3 ){

                    double mincho = Math.round(((weightValue / 2.2046) * 6) * 100);
                    double minchor = mincho / 100;
                    MinCHOResults.setText("Min CHO:" + minchor);

                    double maxcho = Math.round(((weightValue / 2.2046) * 10) * 100);
                    double maxchor = maxcho / 100;
                    MaxChOResults.setText("Max CHO:" + maxchor);
                }
                else if (durValue >= 4) {
                    double mincho = Math.round(((weightValue / 2.2046) * 8) * 100);
                    double minchor = mincho / 100;
                    MinCHOResults.setText("Min CHO:" + minchor);

                    double maxcho = Math.round(((weightValue / 2.2046) * 12) * 100);
                    double maxchor = maxcho / 100;
                    MaxChOResults.setText("Max CHO:" + maxchor);
                }

                double pro1 = Math.round(((weightValue / 2.2046) * 1.2) * 100);
                double pror1 = pro1 / 100;

                double pro2 = Math.round(((weightValue / 2.2046) * 1.4) * 100);
                double pror2 = pro2 / 100;

                double pro3 = Math.round(((weightValue / 2.2046) * 2.2) * 100);
                double pror3 = pro3 / 100;
                PROResults1.setText(("PRO: " + pror1));
                PROResults2.setText(("PRO: " + pror2));
                PROResults3.setText(("PRO: " + pror3));

                if (ACTIVITY .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
            }
            // IF statement to provide calculation based on Female gender and one out of 3 level of activity
            else if (GENDER .equals("Female"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) - 161) * 100);
                double bmrr = bmr / 100;

                // Calculate CHO for female based on hours of training
                if (durValue <= 3 ){

                    double mincho = Math.round(((weightValue / 2.2046) * 6) * 100);
                    double minchor = mincho / 100;
                    MinCHOResults.setText("Min CHO:" + minchor);

                    double maxcho = Math.round(((weightValue / 2.2046) * 10) * 100);
                    double maxchor = maxcho / 100;
                    MaxChOResults.setText("Max CHO:" + maxchor);
                }
                else if (durValue >= 4) {
                    double mincho = Math.round(((weightValue / 2.2046) * 8) * 100);
                    double minchor = mincho / 100;
                    MinCHOResults.setText("Min CHO:" + minchor);

                    double maxcho = Math.round(((weightValue / 2.2046) * 12) * 100);
                    double maxchor = maxcho / 100;
                    MaxChOResults.setText("Max CHO:" + maxchor);
                }

                double pro1 = Math.round(((weightValue / 2.2046) * 1.2) * 100);
                double pror1 = pro1 / 100;

                double pro2 = Math.round(((weightValue / 2.2046) * 1.4) * 100);
                double pror2 = pro2 / 100;

                double pro3 = Math.round(((weightValue / 2.2046) * 2.2) * 100);
                double pror3 = pro3 / 100;
                PROResults1.setText(("PRO: " + pror1));
                PROResults2.setText(("PRO: " + pror2));
                PROResults3.setText(("PRO: " + pror3));

                BMRResults.setText("BMR: " + bmrr);
                if (ACTIVITY .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
            }
        }

        if (ACTYPE.equals("Competition") && HEIGHT != null && !"".equals(HEIGHT)&& WEIGHT != null && !"".equals(WEIGHT) && AGE != null && !"".equals(AGE) && GENDER != "Gender" && !"".equals(GENDER) && ACTIVITY != "Activity Level" && !"".equals(ACTIVITY)){
            double heightValue = Double.parseDouble(HEIGHT);
            double weightValue = Double.parseDouble(WEIGHT);
            double ageValue = Double.parseDouble(AGE);

            // IF statement to provide calculation based on Male gender and one out of 3 level of activity
            if (GENDER .equals("Male"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) + 5) * 100);
                double bmrr = bmr / 100;
                BMRResults.setText("BMR: " + bmrr);

                // Calculate CHO for male based on hour of training
                double mincho = Math.round(((weightValue / 2.2046) * 10) * 100);
                double minchor = mincho / 100;
                MinCHOResults.setText("Min CHO:" + minchor);

                double maxcho = Math.round(((weightValue / 2.2046) * 8) * 100);
                double maxchor = maxcho / 100;
                MaxChOResults.setText("Max CHO:" + maxchor);

                double pro1 = Math.round(((weightValue / 2.2046) * 1.2) * 100);
                double pror1 = pro1 / 100;

                double pro2 = Math.round(((weightValue / 2.2046) * 1.4) * 100);
                double pror2 = pro2 / 100;

                double pro3 = Math.round(((weightValue / 2.2046) * 2.2) * 100);
                double pror3 = pro3 / 100;
                PROResults1.setText(("PRO: " + pror1));
                PROResults2.setText(("PRO: " + pror2));
                PROResults3.setText(("PRO: " + pror3));

                if (ACTIVITY .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
            }
            // IF statement to provide calculation based on Female gender and one out of 3 level of activity
            else if (GENDER .equals("Female"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) - 161) * 100);
                double bmrr = bmr / 100;

                // Calculate CHO for male based on hour of training
                double mincho = Math.round(((weightValue / 2.2046) * 10) * 100);
                double minchor = mincho / 100;
                MinCHOResults.setText("Min CHO:" + minchor);

                double maxcho = Math.round(((weightValue / 2.2046) * 8) * 100);
                double maxchor = maxcho / 100;
                MaxChOResults.setText("Max CHO:" + maxchor);

                double pro1 = Math.round(((weightValue / 2.2046) * 1.2) * 100);
                double pror1 = pro1 / 100;

                double pro2 = Math.round(((weightValue / 2.2046) * 1.4) * 100);
                double pror2 = pro2 / 100;

                double pro3 = Math.round(((weightValue / 2.2046) * 2.2) * 100);
                double pror3 = pro3 / 100;
                PROResults1.setText(("PRO: " + pror1));
                PROResults2.setText(("PRO: " + pror2));
                PROResults3.setText(("PRO: " + pror3));
                BMRResults.setText("BMR: " + bmrr);

                if (ACTIVITY .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    TDEEResults.setText("TDEE: " + dtee / 100);
                }
            }
        }
        else
            {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
        }
    }
}

