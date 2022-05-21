package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Register extends AppCompatActivity {
    EditText IDField, emailField, nameField, passwordField,confirmpassField;
    Button registerButton;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference userReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        IDField = findViewById(R.id.et_ID);
        emailField = findViewById(R.id.et_email);
        nameField = findViewById(R.id.et_name);
        passwordField = findViewById(R.id.et_password);
        confirmpassField = findViewById(R.id.et_confirmpass);
        registerButton = findViewById(R.id.register_btn);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://finalproject-96b93-default-rtdb.firebaseio.com/");


        registerButton.setOnClickListener(view -> {
            String ID = IDField.getText().toString();
            String email = emailField.getText().toString();
            String name = nameField.getText().toString();
            String password = passwordField.getText().toString();
            String confirmpass = confirmpassField.getText().toString();

            if(!email.contains("@") || !email.endsWith(".com")){
                Toast.makeText(this, "Email harus ada character ‘@’dan diakhiri dengan ‘.com’", Toast.LENGTH_SHORT).show();
            }else if(name.length() < 5) {
                Toast.makeText(this, "Nama harus terdiri dari minimal 5 huruf", Toast.LENGTH_SHORT).show();
            }else if(!password.equals(confirmpass)){
                Toast.makeText(this, "Password yang dimasukan harus cocok!", Toast.LENGTH_SHORT).show();
            }else if(ID.isEmpty() || confirmpass.isEmpty()){
                Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show();
            }else {
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(this, "Register failed! Try again", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "Register Success!!", Toast.LENGTH_SHORT).show();
                        userReference = firebaseDatabase.getReference().child("murid").child(Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid());
                        userReference.setValue(new User(ID, email));
                        startActivity(new Intent(Register.this, MainActivity.class));
                        finish();
                    }

                        });
            }

        });

    }
}