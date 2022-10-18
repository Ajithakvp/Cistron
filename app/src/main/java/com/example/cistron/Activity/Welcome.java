package com.example.cistron.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.cistron.Fragment.Attendence;
import com.example.cistron.Fragment.Home;
import com.example.cistron.Fragment.Payment;
import com.example.cistron.Fragment.Report_and_reviews;
import com.example.cistron.Fragment.Sales;
import com.example.cistron.MainActivity;
import com.example.cistron.R;
import com.google.android.material.navigation.NavigationView;

public class Welcome extends AppCompatActivity {


   RelativeLayout rlhome,rlExpenseReport,rlQuoteReport,rlVisitEntryReport;
    private NavigationView nvDrawer;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);






         toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rlhome=findViewById(R.id.rlhome);
        rlExpenseReport=findViewById(R.id.rlExpenseReport1);
        rlQuoteReport=findViewById(R.id.rlQuoteReport);
        rlVisitEntryReport=findViewById(R.id.rlVisitEntryReport);

        setSupportActionBar(toolbar);

        rlQuoteReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                Toast.makeText(Welcome.this, "Logout", Toast.LENGTH_SHORT).show();
                //finish();
            }
        });

        rlExpenseReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//               Fragment attend=new Attendence();
//FragmentManager fragmentManager=getSupportFragmentManager();
//                fragmentManager.beginTransaction().add(R.id.drawer_layout,attend,null).commit();
Intent intent=new Intent(Welcome.this,AttendanceActivity.class);
startActivity(intent);

            }
        });


        rlVisitEntryReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Welcome.this,MycustomerActivity.class);
                startActivity(intent);
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);





        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                Fragment fragment = null;
                rlhome.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();

                if (id == R.id.nav_Attendence) {
                    fragment = new Attendence();
                    rlhome.setVisibility(View.GONE);


                } else if (id == R.id.nav_Sales) {
                    fragment = new Sales();
                    rlhome.setVisibility(View.GONE);

                } else if (id == R.id.nav_Home) {
                    fragment = new Home();
                    rlhome.setVisibility(View.GONE);

                }else if (id == R.id.nav_Report) {
                    fragment = new Report_and_reviews();
                    rlhome.setVisibility(View.GONE);
                } else if (id == R.id.nav_Payment) {
                    rlhome.setVisibility(View.GONE);
                    fragment = new Payment();
                } else if (id == R.id.nav_Logout) {
                   fragment=new Fragment();
                   finish();


                }
               fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
              drawer.closeDrawer(GravityCompat.START);
                return true;

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            rlhome.setVisibility(View.GONE);

        } else {
            super.onBackPressed();
        }
    }



}