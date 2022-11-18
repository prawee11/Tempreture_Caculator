package com.example.tute3_simpletempreturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Button objBtn = findViewById(R.id.btnCalc);
        objBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    private void calculateAnswer() {
        EditText ObjInput = findViewById(R.id.TbinpUsr);
        Calculations objCalcs = new Calculations();
        RadioButton objCel = findViewById(R.id.rbCel);
        RadioButton objfar = findViewById(R.id.RdFr);
        TextView objAns= findViewById(R.id.lblAn);
        if(ObjInput.getText().toString().isEmpty()){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }
    else{
            if( objCel.isChecked()){

        // convert it into Fahrenheit and display the answer
                objAns.setText(String.valueOf(objCalcs.convertCelciusToFahrenheit(Float.valueOf(ObjInput.getText().toString()))));
            }
            else if(!objCel.isChecked()&&!objfar.isChecked())
                Toast.makeText(this, "Please select Temp Unit", Toast.LENGTH_SHORT).show();
            else{
// convert it into Celcius and display the answer
                objAns.setText(String.valueOf(objCalcs.convertFahrenheitToCelcius(Float.valueOf(ObjInput.getText().toString()))));
            }

        }}}