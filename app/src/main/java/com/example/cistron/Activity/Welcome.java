package com.example.cistron.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.cistron.Fragment.Attendence;
import com.example.cistron.Fragment.Home;
import com.example.cistron.Fragment.Payment;
import com.example.cistron.Fragment.Report_and_reviews;
import com.example.cistron.Fragment.Sales;
import com.example.cistron.MainActivity;
import com.example.cistron.R;
import com.google.android.material.navigation.NavigationView;

public class Welcome extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setCheckedItem(R.id.nav_camera);

        FragmentManager fragmentManager = getSupportFragmentManager();
//        ImportFragment fragment = new ImportFragment();
//        fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                Fragment fragment = null;
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (id == R.id.nav_Attendence) {
                    fragment = new Attendence();
                } else if (id == R.id.nav_Sales) {
                    fragment = new Sales();
                } else if (id == R.id.nav_Home) {
                    fragment = new Home();
                }else if (id == R.id.nav_Report) {
                    fragment = new Report_and_reviews();
                } else if (id == R.id.nav_Payment) {
                    fragment = new Payment();
                } else if (id == R.id.nav_Logout) {
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
        } else {
            super.onBackPressed();
        }
    }



}