package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StarActivity extends AppCompatActivity {
    ImageButton bottleBtn;
    ImageButton lionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        init();

        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.star);

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
                        return true;
                    case R.id.diary:
                        startActivity(new Intent(getApplicationContext(),DiaryActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        bottleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void init() {
        bottleBtn = findViewById(R.id.star_bottle_btn);
        lionBtn = findViewById(R.id.star_lion_btn);
    }

}