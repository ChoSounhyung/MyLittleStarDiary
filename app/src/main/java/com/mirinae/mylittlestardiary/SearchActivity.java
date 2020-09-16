package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mirinae.mylittlestardiary.adapter.SearchItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<Diary> diaryList = new ArrayList<>();
    private RecyclerView searchRecyclerView;
    private SearchItemAdapter searchItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setBottomNav();
        init();

        Diary diary = new Diary("2020.09.05", "MyBirthday", "오늘은 내 생일이다. 요즘에 너무 바빠서 내 생일도 잊고 있었는데 친구들이 서프라이즈 파티를 준비했다. 아침마다 아리야에게 오늘의 운세를 물어보는데 맨 처음 멘트가 ‘만족스러운 하루가 기대됩니다.’였다. 그래서 오늘 내내 기분이 좋았는데 친구들이 내 생일을 축하해 줘서 더 만족스러운 하루가 된 것 같다.\n처음에는 너무 놀라고 고마워서 눈물이 났다. 애들이랑 사진을 한 500장 정도 찍은 거 같은데 ㅋㅋㅋㅋ 꼭 인화해서 방 벽에 붙여놔야지. 생일 파티가 끝나고 친구들이랑 집에서 영화를 봤다. 이런 친구들이 없었다면 이번 생일은 미역국도 생일 케이크도 없이 그냥 지나갔을 텐데.. 잊지 않고 챙겨준 친구들의 생일에 내가 느낀 감동을 배로 전해주고 싶다.");

        diaryList.add(diary);

        // RecyclerView Adapter 생성 및 Diary List 전달
        searchItemAdapter = new SearchItemAdapter(diaryList, this);
        // RecyclerView Manager를 LinearLayout으로 설정
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // RecyclerView Adapter 설정
        searchRecyclerView.setAdapter(searchItemAdapter);

    }

    public void init() {
        searchRecyclerView = findViewById(R.id.search_recyclerview);
    }

    public void setBottomNav() {
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.search);

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
                    case R.id.search:
                        return true;
                }
                return false;
            }
        });
    }

}