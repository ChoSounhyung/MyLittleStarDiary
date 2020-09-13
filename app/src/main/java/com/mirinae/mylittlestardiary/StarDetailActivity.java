package com.mirinae.mylittlestardiary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StarDetailActivity extends AppCompatActivity {
    private ImageView backBtn;

    private ImageView DetailStar;
    private TextView DetailDate;
    private TextView DetailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_detail);

        init();
        onActivity();
        backBtn.setOnClickListener(goBackPage);
    }

    private void init() {
        backBtn = findViewById(R.id.star_back);
        DetailStar = findViewById(R.id.star_detail_star);
        DetailDate = findViewById(R.id.star_detail_date);
        DetailText = findViewById(R.id.star_detail_text);
    }

    View.OnClickListener goBackPage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StarDetailActivity.this.finish();
        }
    };

    protected void onActivity() {
        Bundle b = getIntent().getExtras();

        int image_link = (int) b.get("image");
        String date = (String) b.get(StarActivity.EXTRA_DATE);
        String text = (String) b.get(StarActivity.EXTRA_TEXT);

        switch (date) {
            case "1/20~2/18":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "2/19~3/20":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "3/21~4/19":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "4/20~5/20":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "5/21~6/21":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "6/22~7/22":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "7/23~8/22":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "8/23~9/23":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "9/24~10/22":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "10/23~11/22":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "11/23~12/24":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
            case "12/25~1/19":
                DetailStar.setImageResource(image_link);
                DetailDate.setText(date);
                DetailText.setText(text);
                break;
        }

    }
}