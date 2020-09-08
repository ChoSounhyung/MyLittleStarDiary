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

import java.util.List;

public class DiaryItemAdapter extends RecyclerView.Adapter<DiaryItemAdapter.SearchItemViewHolder> {
    private List<Diary> diaryList;
    private Activity searchActivity;

    public static class SearchItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout searchItemContainer;
        TextView searchTitle;

        // Constructor
        public SearchItemViewHolder(View v) {
            super(v);
            searchItemContainer = (LinearLayout) v.findViewById(R.id.search_item_container);
            searchTitle = (TextView) v.findViewById(R.id.search_title);
        }
    }

    // Constructor
    public SearchItemAdapter(List<Cosmetic> cosmetics, Activity searchActivity) {
        this.cosmetics = cosmetics;
        this.searchActivity = searchActivity;
    }

    @NonNull
    @Override
    public SearchItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_item, viewGroup, false);
        return new SearchItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemViewHolder holder, int position) {// onClick event
        holder.searchItemContainer.setOnClickListener(new ItemClickListener(searchActivity, 1));
    }

    @Override
    public int getItemCount() {
        return cosmetics.size();
    }
}