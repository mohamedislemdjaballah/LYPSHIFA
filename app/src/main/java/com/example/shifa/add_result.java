package com.example.shifa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class add_result extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    Button done , forMe , forOther;

    TextView fillText;
    EditText age ;

    LinearLayout ageGenderReset , userChoice;


    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result);
        spinner = findViewById(R.id.ageReset);

        //getting the buttons from all the layour
        done = findViewById(R.id.doneReseting);
        forMe = findViewById(R.id.forMe);
        forOther = findViewById(R.id.forOther);

        //getting all layouts
        ageGenderReset = findViewById(R.id.ageGenderRCompat);
        userChoice = findViewById(R.id.userChoice_com);

        //getting all text views
        fillText = findViewById(R.id.fillTextId);

        //getting all edittext
        age = findViewById(R.id.ageResetText);

        adapter = ArrayAdapter.createFromResource(this,R.array.DMY, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(this);
        done.setOnClickListener(this);
        forOther.setOnClickListener(this);
        forMe.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String string = parent.getItemAtPosition(position).toString();
        Toast.makeText(this , "The selected Item is : "+string,Toast.LENGTH_SHORT);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == done.getId()){
            try {
                Intent intent = new Intent(this ,com.example.shifa.Exams.class );
                startActivity(intent);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if(view.getId() == forOther.getId()){
            ageGenderReset.setVisibility(View.VISIBLE);
            fillText.setVisibility(View.VISIBLE);
            done.setVisibility(View.VISIBLE);
            userChoice.setVisibility(View.INVISIBLE);
        } else if (view.getId() == forMe.getId()) {
            try {
                Intent intent = new Intent( this, Exams.class);
                startActivity(intent);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}