package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        setBottomNav();
    }

    public void setBottomNav() {
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.diary);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.star:
                        startActivity(new Intent(getApplicationContext(),StarActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.diary:
                        return true;
                }
                return false;
            }
        });
    }
}