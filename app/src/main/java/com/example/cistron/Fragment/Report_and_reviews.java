package com.example.cistron.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.cistron.Activity.AttendanceReports;
import com.example.cistron.Activity.ExpensesReports;
import com.example.cistron.Activity.QuoteReports;
import com.example.cistron.Activity.VisitEntryReports;
import com.example.cistron.R;

public class Report_and_reviews extends Fragment {

    RelativeLayout rlAttendance,rlExpenseReport,rlVisitEntryReport,rlQuoteReport;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_report_and_reviewa, container, false);

        rlAttendance=view.findViewById(R.id.rlAttendance);
        rlExpenseReport=view.findViewById(R.id.rlExpenseReport);
        rlVisitEntryReport=view.findViewById(R.id.rlVisitEntryReport);
        rlQuoteReport=view.findViewById(R.id.rlQuoteReport);


        //Intent

        rlAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent attendance=new Intent(getActivity(), AttendanceReports.class);
                startActivity(attendance);
            }
        });

        rlExpenseReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent expense=new Intent(getActivity(), ExpensesReports.class);
                startActivity(expense);
            }
        });

        rlVisitEntryReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visit=new Intent(getActivity(), VisitEntryReports.class);
                startActivity(visit);
            }
        });

        rlQuoteReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quote=new Intent(getActivity(), QuoteReports.class);
                startActivity(quote);
            }
        });


        return view;
    }
}