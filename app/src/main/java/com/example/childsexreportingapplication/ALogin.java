package com.example.childsexreportingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ALogin extends AppCompatActivity {

    EditText mail, pass;
    Button login;
    private FirebaseAuth gAuth;
    TextView aregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_login);
        getSupportActionBar().setTitle("ADMIN LOGIN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mail = findViewById(R.id.aemail);
        pass = findViewById(R.id.apassword);
        login = findViewById(R.id.btnAsignin);
        aregister = findViewById(R.id.iviyayi);
        gAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mail.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    mail.setError("Email is Required!");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    mail.setError("Password is Required!");
                    return;
                }

                if(password.length()<4)
                {
                    pass.setError("Password Must be >= 4 characters");
                    return;
                }


                gAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(ALogin.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Ahome.class));
                        }
                        else
                        {
                            Toast.makeText(ALogin.this, "Error"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });


        aregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Aregister.class));
            }
        });

    }



}