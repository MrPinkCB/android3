package com.example.assignment3;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.assignment3.ui.dashboard.DashboardFragment;
import com.example.assignment3.ui.home.HomeFragment;
import com.example.assignment3.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_home) {
                    HomeFragment homeFragment = new HomeFragment();
                    fragmentManager = getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, homeFragment, null);
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.navigation_dashboard) {
                    DashboardFragment dashboardFragment = new DashboardFragment();
                    fragmentManager = getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, dashboardFragment, null);
                    fragmentTransaction.commit();
                } else if (item.getItemId() == R.id.navigation_notifications) {
                    NotificationsFragment notificationsFragment = new NotificationsFragment();
                    fragmentManager = getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, notificationsFragment, null);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
        HomeFragment homeFragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, homeFragment, null);
        fragmentTransaction.commit();
    }
}