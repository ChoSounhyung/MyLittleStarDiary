package com.mirinae.mylittlestardiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mirinae.mylittlestardiary.adapter.SearchItemAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mirinae.mylittlestardiary.MainActivity.diaryList;

public class SearchActivity extends AppCompatActivity {

    //private List<Diary> diaryList = new ArrayList<>();
    private RecyclerView searchRecyclerView;
    private SearchItemAdapter searchItemAdapter;
    private EditText keyword;
    private static final String TAG = "스택:메인";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setBottomNav();
        init();

        keyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String keyword = charSequence.toString();
                Log.e(TAG, "레트로핏 시작");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(RetrofitService.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RetrofitService retrofitService = retrofit.create(RetrofitService.class);
                retrofitService.getSearchDiaryList(keyword).enqueue(new Callback<List<Diary>>() {
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
                            searchRecyclerView.smoothScrollToPosition(0);
                        }else{
                            Log.e(TAG, "레트로핏 실패");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Diary>> call, Throwable t) { }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void init() {
        searchRecyclerView = findViewById(R.id.search_recyclerview);
        keyword = findViewById(R.id.search_keyword);
    }

    public void setUp() {
        // RecyclerView Adapter 생성 및 Diary List 전달
        searchItemAdapter = new SearchItemAdapter(diaryList, this);
        // RecyclerView Manager를 LinearLayout으로 설정
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // RecyclerView Adapter 설정
        searchRecyclerView.setAdapter(searchItemAdapter);
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