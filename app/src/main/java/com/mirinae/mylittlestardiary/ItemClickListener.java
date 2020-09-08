package com.mirinae.mylittlestardiary;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class ItemClickListener implements View.OnClickListener {
    private Activity activity;
    private int itemId;

    public ItemClickListener(Activity activity, int itemId) {
        this.activity = activity;
        this.itemId = itemId;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(activity, StarDetailActivity.class);

        intent.putExtra("itemId", itemId);

        activity.startActivity(intent);
    }
}