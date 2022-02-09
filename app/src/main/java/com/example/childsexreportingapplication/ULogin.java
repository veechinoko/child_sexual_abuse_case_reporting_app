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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ULogin extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button btnSign;
    private FirebaseAuth mAuth;
    ProgressBar mprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulogin);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mEmail = findViewById(R.id.editTextEmail);
        mPassword = findViewById(R.id.editTextPass);
        btnSign = findViewById(R.id.btnSignIn);
        mAuth = FirebaseAuth.getInstance();
        mprogress = findViewById(R.id.progressBar);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required!");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required!");
                    return;
                }

                if (password.length() < 4) {
                    mPassword.setError("Password Must be >= 4 characters");
                    return;
                }

                mprogress.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(ULogin.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), SignIn.class));
                        } else {
                            mprogress.setVisibility(View.INVISIBLE);
                            Toast.makeText(ULogin.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    public void signUp(View view)
    {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }


}