package com.example.childsexreportingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetrieveUserComments extends AppCompatActivity {

    ListView listViewComm;
    DatabaseReference ref;
    List<Comments> commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_user_comments);
        listViewComm = findViewById(R.id.ListViewComments);
        commentList = new ArrayList<>();
        ref = FirebaseDatabase.getInstance().getReference("Comments");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                commentList.clear();
                for(DataSnapshot ds : snapshot.getChildren()){
                    Comments comment = ds.getValue(Comments.class);
                    commentList.add(comment);
                }
                CommentsAdapter adapter = new CommentsAdapter(RetrieveUserComments.this, commentList);
                listViewComm.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}