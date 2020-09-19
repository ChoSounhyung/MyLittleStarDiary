package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mirinae.mylittlestardiary.adapter.DiaryItemAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_DIARY_REQUEST = 1;

    private List<Diary> diaryList = new ArrayList<>();
    private RecyclerView diaryRecyclerView;
    private DiaryItemAdapter diaryItemAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBottomNav();
        init();
        setUp();

        //dummy data
        Diary diary = new Diary("2020.09.05", "MyBirthday", "오늘은 내 생일이다. 요즘에 너무 바빠서 내 생일도 잊고 있었는데 친구들이 서프라이즈 파티를 준비했다. 아침마다 아리야에게 오늘의 운세를 물어보는데 맨 처음 멘트가 ‘만족스러운 하루가 기대됩니다.’였다. 그래서 오늘 내내 기분이 좋았는데 친구들이 내 생일을 축하해 줘서 더 만족스러운 하루가 된 것 같다.\n처음에는 너무 놀라고 고마워서 눈물이 났다. 애들이랑 사진을 한 500장 정도 찍은 거 같은데 ㅋㅋㅋㅋ 꼭 인화해서 방 벽에 붙여놔야지. 생일 파티가 끝나고 친구들이랑 집에서 영화를 봤다. 이런 친구들이 없었다면 이번 생일은 미역국도 생일 케이크도 없이 그냥 지나갔을 텐데.. 잊지 않고 챙겨준 친구들의 생일에 내가 느낀 감동을 배로 전해주고 싶다.");
        diaryList.add(diary);

    }

    public void init() {
        diaryRecyclerView = findViewById(R.id.diary_recyclerview);
        fab = findViewById(R.id.fab);
    }

    private void setUp() {
        fab.setOnClickListener(goAddPage);

        // RecyclerView Adapter 생성 및 Diary List 전달
        diaryItemAdapter = new DiaryItemAdapter(diaryList, this);
        // RecyclerView Manager를 LinearLayout으로 설정
        diaryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // RecyclerView Adapter 설정
        diaryRecyclerView.setAdapter(diaryItemAdapter);
    }

    View.OnClickListener goAddPage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivityForResult(intent, ADD_DIARY_REQUEST);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == ADD_DIARY_REQUEST && resultCode == RESULT_OK) {
            String date = intent.getStringExtra("date");
            String title = intent.getStringExtra("title");
            String contents = intent.getStringExtra("contents");

            Toast.makeText(this, "일기가 등록되었습니다.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "일기가 등록되지 않았습니다.", Toast.LENGTH_SHORT).show();
        }
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