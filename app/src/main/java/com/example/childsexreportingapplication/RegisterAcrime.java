package com.example.childsexreportingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterAcrime extends AppCompatActivity {

    EditText mCrimeTitle, mLocation, mContactPhone, mCrimeDetails;
    Button btnRprt;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;
    String crimeTitle, location, contactPhone, crimeDetails;
    ProgressBar mProg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_acrime);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mCrimeTitle = findViewById(R.id.crimeTitle);
        mLocation = findViewById(R.id.Location);
        mContactPhone = findViewById(R.id.contactPhone);
        mCrimeDetails = findViewById(R.id.crimeDetails);
        btnRprt = findViewById(R.id.btnReport);
        mProg = findViewById(R.id.progressBar3);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Crime");

        btnRprt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                storeCrimeDetails();



            }
        });

    }

    private void storeCrimeDetails() {
         crimeTitle = mCrimeTitle.getText().toString();
         location = mLocation.getText().toString();
         contactPhone = mContactPhone.getText().toString();
         crimeDetails = mCrimeDetails.getText().toString();
         UserCrimedetails addCrimeDetails = new UserCrimedetails(crimeTitle,location,contactPhone,crimeDetails);
        reference.push().setValue(addCrimeDetails);
        Toast.makeText(RegisterAcrime.this, "Crime complaint Sent", Toast.LENGTH_SHORT).show();
    }
}