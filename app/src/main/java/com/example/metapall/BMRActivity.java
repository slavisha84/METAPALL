package com.example.metapall;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private TextView result1;
    private TextView result2;
    private Spinner Gspinner;
    private Spinner Aspinner;
    private String genderCh;
    private String ActvCh;

    DatabaseHelper PersonalDB;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        age = (EditText) findViewById(R.id.age);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);

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

        // if statement to execute if all required values are present
        if (HEIGHT != null && !"".equals(HEIGHT)&& WEIGHT != null && !"".equals(WEIGHT) && AGE != null && !"".equals(AGE) && GENDER != "Gender" && !"".equals(GENDER) && ACTIVITY != "Activity Level" && !"".equals(ACTIVITY)){
            double heightValue = Double.parseDouble(HEIGHT);
            double weightValue = Double.parseDouble(WEIGHT);
            double ageValue = Double.parseDouble(AGE);

            // IF statement to provide calculation based on Male gender and one out of 3 level of activity
            if (GENDER .equals("Male"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) + 5) * 100);
                double bmrr = bmr / 100;
                result1.setText("YOUR BMR IS: " + bmrr);
                if (ACTIVITY .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
            }
            // IF statement to provide calculation based on Female gender and one out of 3 level of activity
            else if (GENDER .equals("Female"))
            {
                double bmr = Math.round((((weightValue / 2.2046) * 10) + (6.25 * (heightValue * 30.48)) - (5 * ageValue) - 161) * 100);
                double bmrr = bmr / 100;
                result1.setText("YOUR BMR IS: " + bmrr);
                if (ACTIVITY .equals("Light"))
                {
                    double dtee = Math.round((bmrr * 1.53) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Moderate"))
                {
                    double dtee = Math.round((bmrr * 1.76) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
                else if (ACTIVITY .equals("Vigorous"))
                {
                    double dtee = Math.round((bmrr * 2.25) * 100);
                    result2.setText("YOUR DTEE IS: " + dtee / 100);
                }
            }
        }
        else
            {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
        }
    }
}

