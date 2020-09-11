package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;

public class StarActivity extends AppCompatActivity {
    public static final String EXTRA_STAR = "com.mirinae.mylittlestardiary.EXTRA_STAR";
    public static final String EXTRA_DATE = "com.mirinae.mylittlestardiary.EXTRA_DATE";
    public static final String EXTRA_TEXT = "com.mirinae.mylittlestardiary.EXTRA_TEXT";

    private TextView detailDate;
    private TextView detailText;

    private ImageView bottle;
    private ImageView fish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        init();
        setBottomNav();
        setUp();

    }

    public void init() {
        detailDate = findViewById(R.id.star_detail_date);
        detailText = findViewById(R.id.star_detail_text);
        bottle = findViewById(R.id.star_bottle_btn);
        fish = findViewById(R.id.star_fish_btn);
    }

    public void setUp() {
        bottle.setOnClickListener(goDetailPage);
        fish.setOnClickListener(goDetailPage);
    }

    View.OnClickListener goDetailPage = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

        }
    };

    public void setBottomNav() {
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
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

}