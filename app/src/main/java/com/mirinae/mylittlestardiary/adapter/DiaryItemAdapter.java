package com.mirinae.mylittlestardiary.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirinae.mylittlestardiary.Diary;
import com.mirinae.mylittlestardiary.DiaryClickListener;
import com.mirinae.mylittlestardiary.DiaryDetailActivity;
import com.mirinae.mylittlestardiary.MainActivity;
import com.mirinae.mylittlestardiary.R;

import org.w3c.dom.Text;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;


public class DiaryItemAdapter extends RecyclerView.Adapter<DiaryItemAdapter.DiaryItemViewHolder> {
    private List<Diary> diaryList;
    private Activity mainActivity;

    public static class DiaryItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout diaryItemContainer;
        TextView diaryDate;
        TextView diaryTitle;

        // Constructor
        public DiaryItemViewHolder(View v) {
            super(v);
            diaryItemContainer = (LinearLayout) v.findViewById(R.id.diary_item_container);
            diaryDate = v.findViewById(R.id.diary_date);
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
    public void onBindViewHolder(@NonNull DiaryItemAdapter.DiaryItemViewHolder holder, int position) {// onClick event
        holder.diaryItemContainer.setOnClickListener(new DiaryClickListener(mainActivity, position));
        holder.diaryTitle.setText(diaryList.get(position).getTitle());
        holder.diaryDate.setText(diaryList.get(position).getDiary_day());
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }


}
