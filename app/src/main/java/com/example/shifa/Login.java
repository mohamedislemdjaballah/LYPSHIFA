package com.example.shifa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Button login;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signUp);
        login.setOnClickListener(this);

        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == login.getId()){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if(view.getId() == signup.getId()){
            signup.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this, Signup.class);
            startActivity(intent);
        }

    }
}