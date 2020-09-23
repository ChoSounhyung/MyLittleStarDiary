package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mirinae.mylittlestardiary.adapter.DiaryItemAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final int ADD_DIARY_REQUEST = 1;
    private static final String TAG = "스택:메인";

    private static List<Diary> diaryList = new ArrayList<>();
    private RecyclerView diaryRecyclerView;
    private RecyclerView.Adapter diaryItemAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "레트로핏 시작");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.getDiaryList().enqueue(new Callback<List<Diary>>() {
            @Override
            public void onResponse(Call<List<Diary>> call, Response<List<Diary>> response) {
                Log.e(TAG, "레트로핏 get요청");
                if (response.isSuccessful()) {
                    Log.e(TAG, "레트로핏 get 성공");
                    diaryList = response.body();
                    for(int i = 0; i < diaryList.size(); i++){
                        Log.e(TAG,diaryList.get(i).getTitle());
                    }
                    setUp();
                    diaryRecyclerView.smoothScrollToPosition(0);
                }else{
                    Log.e(TAG, "레트로핏 실패");
                }
            }

            @Override
            public void onFailure(Call<List<Diary>> call, Throwable t) { }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBottomNav();
        init();
        //setUp();

//        Diary diary1 = new Diary("MyBirthday", "2020.09.21");
//        Diary diary2 = new Diary("ㅁㄴㅇㄹ", "2020.08.08");
//        Diary diary3 = new Diary("ㄴㅇㅀ", "2020.07.26");
//        Diary diary4 = new Diary("ㅂㅈㄷㄱ", "2020.10.06");
//        diaryList.add(diary1);
//        diaryList.add(diary2);
//        diaryList.add(diary3);
//        diaryList.add(diary4);

    }

    public void init() {
        diaryRecyclerView = findViewById(R.id.diary_recyclerview);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(goAddPage);
    }

    private void setUp() {
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