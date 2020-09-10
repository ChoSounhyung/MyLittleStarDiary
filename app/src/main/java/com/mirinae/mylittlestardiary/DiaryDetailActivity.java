package com.mirinae.mylittlestardiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class DiaryDetailActivity extends AppCompatActivity {

    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);

        init();
        setUp();
    }

    private void init() {
        backBtn = (ImageView) findViewById(R.id.diary_back);
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