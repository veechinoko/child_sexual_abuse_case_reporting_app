package com.example.childsexreportingapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Acrimes extends AppCompatActivity {

    ListView myListView;
    List<UserCrimedetails> crimesList;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acrimes);

        myListView = findViewById(R.id.listV);
        crimesList = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("Crime");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                crimesList.clear();
                for(DataSnapshot ds : snapshot.getChildren()){
                    UserCrimedetails addCrimeDetails = ds.getValue(UserCrimedetails.class);
                    crimesList.add(addCrimeDetails);
                }

                AcrimesAdapter adapter = new AcrimesAdapter(Acrimes.this,crimesList);
                myListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}