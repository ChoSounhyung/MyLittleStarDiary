package com.mirinae.mylittlestardiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DiaryDetailActivity extends AppCompatActivity {

    private ImageView backBtn;
    private TextView diary_date;
    private TextView diary_title;
    private TextView diary_contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra("itemId", -1);
        Diary diary = MainActivity.diaryList.get(position);
        //Toast.makeText(this, "제목은 " + diary.getTitle(), Toast.LENGTH_SHORT).show();

        init();
        setUp();

        diary_date.setText(diary.getDiary_day());
        diary_title.setText(diary.getTitle());
        diary_contents.setText(diary.getContent());


    }

    private void init() {
        backBtn = (ImageView) findViewById(R.id.diary_back);
        diary_date = findViewById(R.id.diary_date);
        diary_title = findViewById(R.id.diary_title);
        diary_contents = findViewById(R.id.diary_contents);
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