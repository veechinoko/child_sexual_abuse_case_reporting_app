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

public class AcrimesAdapter extends ArrayAdapter {

    private Activity mcontext;
    List<UserCrimedetails> crimesList;
     public  AcrimesAdapter(Activity mcontext, List<UserCrimedetails> crimesList)
     {
         super(mcontext,R.layout.crimes_list, crimesList);
         this.mcontext = mcontext;
         this.crimesList = crimesList;
     }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mcontext.getLayoutInflater();
        View crimeItemView =  inflater.inflate(R.layout.crimes_list, null, true);
        TextView     Title = crimeItemView.findViewById(R.id.textTitle);
        TextView    Loc = crimeItemView.findViewById(R.id.textLocation);
        TextView     Contact = crimeItemView.findViewById(R.id.textContactPhone);
        TextView     Det = crimeItemView.findViewById(R.id.textDetails);

        UserCrimedetails addCrimeDetails = crimesList.get(position);

        Title.setText("Crime Title: "  +addCrimeDetails.getCrimeTitle());
        Contact.setText("Contact Phone: "+ addCrimeDetails.getContactPhone());
        Loc.setText("Location: " + addCrimeDetails.getLocation());
        Det.setText("Full Details: " + addCrimeDetails.getCrimeDetails());

        return  crimeItemView;
    }
}
