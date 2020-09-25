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
import com.mirinae.mylittlestardiary.DiaryClickListener;
import com.mirinae.mylittlestardiary.R;

import java.util.List;

public class SearchItemAdapter extends RecyclerView.Adapter<SearchItemAdapter.SearchItemViewHolder> {
    private List<Diary> diaryList;
    private Activity searchActivity;

    public static class SearchItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout searchItemContainer;
        TextView searchTitle;
        TextView searchDate;

        // Constructor
        public SearchItemViewHolder(View v) {
            super(v);
            searchItemContainer = (LinearLayout) v.findViewById(R.id.search_item_container);
            searchTitle = (TextView) v.findViewById(R.id.search_title);
            searchDate = v.findViewById(R.id.search_date);
        }
    }

    // Constructor
    public SearchItemAdapter(List<Diary> diaryList, Activity searchActivity) {
        this.diaryList = diaryList;
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
        holder.searchItemContainer.setOnClickListener(new DiaryClickListener(searchActivity, position));
        holder.searchTitle.setText(diaryList.get(position).getTitle());
        holder.searchDate.setText(diaryList.get(position).getDiary_day());
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }
}
