package com.burakod.noticeboard;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ProfileActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(R.id.content,new HomeFragment()).commit();

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mFragmentManager = getSupportFragmentManager();
                mTransaction= mFragmentManager.beginTransaction();

                switch (item.getItemId()){
                    case R.id.navigation_home :
                        mTransaction.replace(R.id.content,new HomeFragment()).commit();
                        return true;
                    case R.id.navigation_addPost:
                        mTransaction.replace(R.id.content,new NewpostFragment()).commit();
                        return true;
                    

                }
                return false;
            }
        });

    }
}
