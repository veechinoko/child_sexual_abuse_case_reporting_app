package com.example.childsexreportingapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CommentsAdapter extends ArrayAdapter {
    private Activity mcontext;
    List<Comments> commentList;
    public  CommentsAdapter(Activity mcontext, List<Comments> commentList)
    {
        super(mcontext,R.layout.user_comments, commentList);
        this.mcontext = mcontext;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mcontext.getLayoutInflater();
        View crimeItemView =  inflater.inflate(R.layout.user_comments, null, true);
        TextView Comment = crimeItemView.findViewById(R.id.userC);
        Comments comment = commentList.get(position);

        Comment.setText(comment.getComments());
        return  crimeItemView;
    }
}
