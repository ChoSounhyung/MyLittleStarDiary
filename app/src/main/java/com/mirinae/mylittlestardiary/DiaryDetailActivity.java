package com.mirinae.mylittlestardiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class DiaryDetailActivity extends AppCompatActivity {

    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);

        init();
        Log.d("태그", "정상적으로 init됨");
        setUp();
        Log.d("태그", "정상적으로 setup됨");
    }

    private void init() {
        backBtn = findViewById(R.id.diary_back);
    }

    private void setUp() {
        backBtn.setOnClickListener(goBackPage);
    }

    View.OnClickListener goBackPage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DiaryDetailActivity.this.finish();
        }
    };
}