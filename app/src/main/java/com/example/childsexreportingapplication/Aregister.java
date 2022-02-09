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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Aregister extends AppCompatActivity {

    EditText fullname, gender, contact_phone, email, password;
    Button Register;
    TextView atologin;
    private FirebaseAuth fmAuth;
    String fname, gen, cPhone, Mail, Pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aregister);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fullname = findViewById(R.id.afullname);
        gender = findViewById(R.id.agenda);
        contact_phone = findViewById(R.id.acontactPhone);
        email = findViewById(R.id.aEmail);
        password = findViewById(R.id.aPassword);
        Register = findViewById(R.id.BtnARegister);
        atologin = findViewById(R.id.agotoLogin);
        fmAuth = FirebaseAuth.getInstance();

        if(fmAuth.getCurrentUser()!= null)
        {
            startActivity(new Intent(getApplicationContext(), ALogin.class));
            finish();
        }



        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = fullname.getText().toString();
                gen = gender.getText().toString();
                cPhone = contact_phone.getText().toString();
                Mail = email.getText().toString();
                Pass = password.getText().toString();

                if(TextUtils.isEmpty(Mail))
                {
                    email.setError("Email is Required!");
                    return;
                }

                if(TextUtils.isEmpty(Pass))
                {
                    password.setError("Password is Required!");
                    return;
                }

                if(Pass.length()<4)
                {
                    password.setError("Password Must be >= 4 characters");
                    return;
                }

               fmAuth.createUserWithEmailAndPassword(Mail,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            storeNewAdminData();
                            Toast.makeText(Aregister.this, "Admin Account created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),ALogin.class));
                        }
                        else
                        {
                            Toast.makeText(Aregister.this, "Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });



        atologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ALogin.class));
            }
        });

    }


    private void storeNewAdminData() {
        FirebaseDatabase rootNode2 = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode2.getReference("Admins");
        AdminHelperClass addNewAdmin = new AdminHelperClass(fname, gen, cPhone,Mail,Pass);
        reference.child(cPhone).setValue(addNewAdmin);


    }
}
