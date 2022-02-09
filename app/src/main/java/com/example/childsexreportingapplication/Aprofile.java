package com.example.childsexreportingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Aprofile extends AppCompatActivity {

    TextView Email, Phone, Gender, facebook;
    FirebaseDatabase database;
    DatabaseReference reference;
    String foni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprofile);
        Intent intent = getIntent();
         foni = intent.getStringExtra("aConatct_Phone");

        Email = findViewById(R.id.email_TextView);
        Phone = findViewById(R.id.phone_TextView);
        Gender = findViewById(R.id.gender_TextView);
        facebook = findViewById(R.id.facebook_TextView);


        reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref= reference.child("Admins");

        Log.v("aConatct_Phone", ref.orderByChild("aConatct_Phone").equalTo(foni).toString());


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren())
                {
                    if(ds.child("aConatct_Phone").getValue().equals(foni))
                    {

                        Email.setText(ds.child("Email: ").getValue(String.class));
                        Phone.setText(foni);
                        Gender.setText(ds.child("Gender: ").getValue(String.class));
                        facebook.setText(ds.child("Facebook: ").getValue(String.class));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}