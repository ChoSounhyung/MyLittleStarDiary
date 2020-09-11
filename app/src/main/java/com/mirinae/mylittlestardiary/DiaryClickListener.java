package com.mirinae.mylittlestardiary;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class DiaryClickListener implements View.OnClickListener {
    private Activity activity;
    private int itemId;

    public DiaryClickListener(Activity activity, int itemId) {
        this.activity = activity;
        this.itemId = itemId;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, DiaryDetailActivity.class);

        intent.putExtra("itemId", itemId);

        activity.startActivity(intent);
    }
}