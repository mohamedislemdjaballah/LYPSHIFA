package com.example.shifa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    Button signup;
    TextView login;

    TextInputEditText  username,email,age,passwrod,psswrd_cnf,first_name,last_name;
    RadioGroup gender;
    RadioButton male,femal;
    private DataBase db;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new DataBase(this);

        signup = findViewById(R.id.signUp);
        signup.setOnClickListener(this);
        username = findViewById(R.id.usernane_su);
        email = findViewById(R.id.user_email_su);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);



        age = findViewById(R.id.age);


        passwrod = findViewById(R.id.psswrd_su);
        psswrd_cnf = findViewById(R.id.psswrd_conf);

        first_name = findViewById(R.id.name);
        last_name = findViewById(R.id.lastname);

        gender = findViewById(R.id.Gender);
        male = findViewById(R.id.male);
        femal = findViewById(R.id.female);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == login.getId()){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }else if(view.getId() == signup.getId()){

            String sexe = "Male";
            String age_str = age.getText().toString();
            int age_nbr = 0;
            String user_str = username.getText().toString();
            String firstname_str = first_name.getText().toString();
            String lastname_str = last_name.getText().toString();
            String email_str = email.getText().toString();
            String password_str = passwrod.getText().toString();
            String conf_str = psswrd_cnf.getText().toString();
            if(!age_str.isEmpty() )
            {
                age_nbr = Integer.parseInt(age_str.toString());
            }

            if(user_str.isEmpty() || firstname_str.isEmpty() || lastname_str.isEmpty()
                    || email_str.isEmpty() || password_str.isEmpty() || age_str.isEmpty()
                    || sexe.isEmpty() || password_str.isEmpty()
            ) {
                Toast.makeText(this,"Dont leave any blank fields" , Toast.LENGTH_SHORT).show();
            }else{
                db.openDataBase();
                db.createT();
                db.insertUser(user_str,
                        password_str,
                        email_str,
                        firstname_str,
                        lastname_str,
                        age_nbr,
                        sexe);
                db.closeDataBase();
                Toast.makeText(this, "sign up complete hello"+first_name.getText().toString(),Toast.LENGTH_SHORT).show();
                System.out.println("insertion made with success");
            }


        }

    }


}