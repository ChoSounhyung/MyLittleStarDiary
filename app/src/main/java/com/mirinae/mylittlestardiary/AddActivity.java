package com.mirinae.mylittlestardiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    private ImageView backBtn;
    private TextView addBtn;
    private EditText inputDate;
    private EditText inputTitle;
    private EditText inputContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init();
        setUp();

    }

    private void init() {
        backBtn = findViewById(R.id.add_back);
        addBtn = findViewById(R.id.add_btn);
        inputDate = findViewById(R.id.input_date);
        inputTitle = findViewById(R.id.input_title);
        inputContents = findViewById(R.id.input_contents);
    }

    private void setUp() {
        backBtn.setOnClickListener(closePage);
        addBtn.setOnClickListener(saveItem);
    }

    View.OnClickListener closePage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 경고 다이얼로그 띄우기

            new AlertDialog.Builder(AddActivity.this)
                    .setMessage("일기 등록을 취소하시겠습니까?")
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AddActivity.this.finish();
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
                        }
                    }).show();

        }
    };

    View.OnClickListener saveItem = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String date = inputDate.getText().toString().trim();
            String title = inputTitle.getText().toString().trim();
            String contents = inputContents.getText().toString().trim();

            if (date.length() == 0 || title.length() == 0 || contents.length() == 0) {
                Toast.makeText(getApplicationContext(), "날짜, 제목, 내용은 필수 항목입니다.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("date", date);
                intent.putExtra("title", title);
                intent.putExtra("contents", contents);

                setResult(RESULT_OK, intent);

                AddActivity.this.finish();
            }
        }
    };
}