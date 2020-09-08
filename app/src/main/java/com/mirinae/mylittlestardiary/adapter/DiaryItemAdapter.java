package com.mirinae.mylittlestardiary.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirinae.mylittlestardiary.Diary;
import com.mirinae.mylittlestardiary.ItemClickListener;
import com.mirinae.mylittlestardiary.R;

import java.util.List;


public class DiaryItemAdapter extends RecyclerView.Adapter<DiaryItemAdapter.DiaryItemViewHolder> {
    private List<Diary> diaryList;
    private Activity mainActivity;

    public static class DiaryItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout diaryItemContainer;
        TextView diaryTitle;

        // Constructor
        public DiaryItemViewHolder(View v) {
            super(v);
            diaryItemContainer = (LinearLayout) v.findViewById(R.id.diary_item_container);
            diaryTitle = (TextView) v.findViewById(R.id.diary_title);
        }
    }

    // Constructor
    public DiaryItemAdapter(List<Diary> diaryList, Activity mainActivity) {
        this.diaryList = diaryList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public DiaryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.diary_item, viewGroup, false);
        return new DiaryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryItemViewHolder holder, int position) {// onClick event
        holder.diaryItemContainer.setOnClickListener(new ItemClickListener(mainActivity, 1));
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }
}
