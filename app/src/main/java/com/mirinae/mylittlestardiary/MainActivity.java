package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mirinae.mylittlestardiary.adapter.DiaryItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Diary> diaryList = new ArrayList<>();
    private RecyclerView diaryRecyclerView;
    private DiaryItemAdapter diaryItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBottomNav();
        init();

        Diary diary1 = new Diary("2020.09.05", "집 가고 싶다", "요즘에는 집에 있는데도 집에 가고싶은 기분이다..");
        Diary diary2 = new Diary("2020.09.08", "오느른 내생일", "오늘은 드디어 내 생일이다. 생일인데 집에서 온라인 수업을 듣다니, 기숙사가 아닌걸 다해이라고 해야되나.");

        diaryList.add(diary1);
        diaryList.add(diary2);

        // RecyclerView Adapter 생성 및 Diary List 전달
        diaryItemAdapter = new DiaryItemAdapter(diaryList, this);
        // RecyclerView Manager를 LinearLayout으로 설정
        diaryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // RecyclerView Adapter 설정
        diaryRecyclerView.setAdapter(diaryItemAdapter);

    }

    public void init() {
        diaryRecyclerView = findViewById(R.id.diary_recyclerview);
    }

    public void setBottomNav() {
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.star:
                        startActivity(new Intent(getApplicationContext(),StarActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.add:
                        startActivity(new Intent(getApplicationContext(), AddActivity.class));
                        overridePendingTransition(0, 0);
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