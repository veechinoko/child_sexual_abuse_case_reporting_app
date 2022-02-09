package com.example.childsexreportingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class uComments extends AppCompatActivity {

    EditText postComments;
    Button com;
    FirebaseDatabase database;
    DatabaseReference ref;
    String comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_comments);

        com = findViewById(R.id.btnCommentt);
        postComments =  findViewById(R.id.editTextpostComments);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Comments");


        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoreComments();
            }
        });
    }

    public void StoreComments()
    {
        comments = postComments.getText().toString();
        Comments comment = new Comments(comments);
        ref.push().setValue(comment);
        Toast.makeText(this,"Comment sent!!", Toast.LENGTH_LONG).show();

    }


    public void ViewUserComments(View view) {
        startActivity(new Intent(getApplicationContext(), RetrieveUserComments.class));
    }
}