package com.example.cistron.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.cistron.Activity.AttendanceActivity;
import com.example.cistron.Activity.MycustomerActivity;
import com.example.cistron.R;


public class Home extends Fragment {

    RelativeLayout rlExpenseReport1,rlVisitEntryReport,rlQuoteReport;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);


        rlExpenseReport1=view.findViewById(R.id.rlExpenseReport1);
        rlVisitEntryReport=view.findViewById(R.id.rlVisitEntryReport);
        rlQuoteReport=view.findViewById(R.id.rlQuoteReport);

        rlExpenseReport1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),AttendanceActivity.class);
                startActivity(intent);
            }
        });

        rlVisitEntryReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MycustomerActivity.class);
                startActivity(intent);
            }
        });
        rlQuoteReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });

        return view;


    }
}