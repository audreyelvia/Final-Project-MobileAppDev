package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText  emailField, passwordField;
    Button loginButton;
    TextView registerLink;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        emailField = findViewById(R.id.et_email);
        passwordField = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.login_btn);
        firebaseAuth = FirebaseAuth.getInstance();
        registerLink = findViewById(R.id.register_link);

        registerLink.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Register.class)));

        loginButton.setOnClickListener(view -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(MainActivity.this, task -> {
                if(!task.isSuccessful()){
                    Toast.makeText(this, "Account not registered!", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(MainActivity.this, Homepage.class));
                    finish();
                }
            });
        });
    }
}