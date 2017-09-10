package com.ccgpa.ihumaun.convertcgpa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner homeSpinner;
    private Spinner abroadSpinner;

    private static final String[]homes = {"-select-your-country-","Bangladesh"};
    private static final String[]abroads = {"-select-target-country-","Australia","Canada","Germany", "USA","UK"};

    String homeString;
    String abroadString;
    int countryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homeSpinner = (Spinner)findViewById(R.id.home);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, homes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        homeSpinner.setAdapter(adapter);
        homeSpinner.setOnItemSelectedListener(this);


        abroadSpinner = (Spinner)findViewById(R.id.abroad);
        ArrayAdapter<String> adapterAbroad = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,abroads);
        adapterAbroad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        abroadSpinner.setAdapter(adapterAbroad);
        abroadSpinner.setOnItemSelectedListener(this);


    }

    public void ResetClick(View view){


        EditText cgpaCount = (EditText)findViewById(R.id.cgpa);
        TextView resultText = (TextView)findViewById(R.id.result);

        homeSpinner = (Spinner)findViewById(R.id.home);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, homes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        homeSpinner.setAdapter(adapter);
        homeSpinner.setOnItemSelectedListener(this);


        abroadSpinner = (Spinner)findViewById(R.id.abroad);
        ArrayAdapter<String> adapterAbroad = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,abroads);
        adapterAbroad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        abroadSpinner.setAdapter(adapterAbroad);
        abroadSpinner.setOnItemSelectedListener(this);


        cgpaCount.setText("");
        resultText.setText("Converted CGPA will show here.\nYour CGPA         : xx.yy\nConverted CGPA : ww.zz");

    }


    public void ConvertClick(View view){

        EditText cgpaCount = (EditText)findViewById(R.id.cgpa);
        TextView resultConverted = (TextView)findViewById(R.id.result);

        String cgpaString;
        float cgpafloat;
        float convertedCGPA;

        cgpaString = cgpaCount.getText().toString();

        if(abroadString.contentEquals("-select-target-country-") || cgpaString.contentEquals("") || homeString.contentEquals("-select-your-country-")){
            Toast.makeText(getApplicationContext(),"Please fill every field!",Toast.LENGTH_SHORT).show();
        }
        else{
            cgpafloat = Float.parseFloat(cgpaCount.getText().toString());

            if(countryID == 1) {
                convertedCGPA = (cgpafloat + 3.00F);
                resultConverted.setText("Converted CGPA in "+abroadString+" is shown.\nYour CGPA         : "+String.format("%.2f",cgpafloat)+"\nConverted CGPA : "+String.format("%.2f",convertedCGPA));
            }
            else if(countryID == 2) {
                convertedCGPA = cgpafloat;
                resultConverted.setText("Converted CGPA in "+abroadString+" is shown.\nYour CGPA         : "+String.format("%.2f",cgpafloat)+"\nConverted CGPA : "+String.format("%.2f",convertedCGPA));
            }
            else if(countryID == 3) {
                convertedCGPA = ( (4.00F-cgpafloat) / (4.00F - 1.00F) ) * 3 + 1;
                resultConverted.setText("Converted CGPA in "+abroadString+" is shown.\nYour CGPA         : "+String.format("%.2f",cgpafloat)+"\nConverted CGPA : "+ String.format("%.2f",convertedCGPA));
            }
            else if(countryID == 4) {
                convertedCGPA = cgpafloat;
                resultConverted.setText("Converted CGPA in "+abroadString+" is shown.\nYour CGPA         : "+String.format("%.2f",cgpafloat)+"\nConverted CGPA : "+String.format("%.2f",convertedCGPA));
            }
            else if(countryID == 5) {
                convertedCGPA = (cgpafloat);
                resultConverted.setText("Converted CGPA in "+abroadString+" is shown.\nYour CGPA         : "+String.format("%.2f",cgpafloat)+"\nConverted CGPA : "+String.format("%.2f",convertedCGPA));
            }




        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner idSpinner = (Spinner) adapterView;

        if(idSpinner.getId() == R.id.home ) {
            homeString = adapterView.getItemAtPosition(i).toString();
        }
        else if( idSpinner.getId() == R.id.abroad ) {
            abroadString = adapterView.getItemAtPosition(i).toString();
            countryID = i;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
