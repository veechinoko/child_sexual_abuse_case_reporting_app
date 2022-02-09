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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
     EditText mFullname, mEmail, mPassword, mPhone;
    Button mRegisterbtn;
    ProgressBar mprog;
    String email,password, fullname, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mFullname = findViewById(R.id.editTextPersonName);
        mEmail = findViewById(R.id.editTextEmailAddress);
        mPassword = findViewById(R.id.editTextPassword);
        mPhone = findViewById(R.id.editTextphone);
        mRegisterbtn =findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();
        mprog= findViewById(R.id.progressBar2);

        if(mAuth.getCurrentUser()!= null)
        {
            startActivity(new Intent(getApplicationContext(), ULogin.class));
            finish();
        }

        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email = mEmail.getText().toString().trim();
                 password = mPassword.getText().toString().trim();
                 fullname = mFullname.getText().toString().trim();
                 phone = mPhone.getText().toString();

                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("Email is Required!");
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    mPassword.setError("Password is Required!");
                    return;
                }

                if(password.length()<4)
                {
                    mPassword.setError("Password Must be >= 4 characters");
                    return;
                }

                mprog.setVisibility(View.VISIBLE);

               mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()){
                           storeNewUsersData();
                           Toast.makeText(SignUp.this, "User created", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(), ULogin.class));
                       }
                       else
                       {
                           Toast.makeText(SignUp.this, "Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                       }

                   }
               });
            }
        });

    }

    private void storeNewUsersData() {
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");
        UserHelperClass addNewUser = new UserHelperClass(email, password, fullname, phone);
        reference.child(phone).setValue(addNewUser);
    }
}