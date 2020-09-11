package com.mirinae.mylittlestardiary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StarDetailActivity extends AppCompatActivity {
    private ImageView bottle;
    private ImageView fish;

    private TextView Detaildate;
    private TextView Detailtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_detail);

        Detaildate = findViewById(R.id.star_detail_date);
        Detailtext = findViewById(R.id.star_detail_text);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}