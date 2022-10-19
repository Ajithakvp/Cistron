package com.example.cistron.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.cistron.Activity.AttendanceActivity;
import com.example.cistron.Activity.ExpenseActivity;
import com.example.cistron.Activity.LeaveActivity;
import com.example.cistron.R;

public class Attendence extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_attendence, container, false);


        //FindbyId
        RelativeLayout b =  rootview.findViewById(R.id.rlAttendance1);
        RelativeLayout rlExpenseReport=rootview.findViewById(R.id.rlExpenseReport);
        RelativeLayout rlVisitEntryReport=rootview.findViewById(R.id.rlVisitEntryReport);



        //Intent

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AttendanceActivity.class);
                startActivity(intent);

            }

        });


        rlExpenseReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent expense=new Intent(getActivity(), ExpenseActivity.class);
                startActivity(expense);
            }
        });


        rlVisitEntryReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent leave=new Intent(getActivity(), LeaveActivity.class);
                startActivity(leave);
            }
        });



        return rootview;

    }
}