package fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mirinae.mylittlestardiary.Diary;
import com.mirinae.mylittlestardiary.R;

import java.util.ArrayList;
import java.util.List;

public class DiaryFragment extends Fragment {

    private List<Diary> diaryList = new ArrayList<>();
    private RecyclerView diaryRecyclerView;
    private TextView diaryTitle;
    private Activity mainActivity;

    public DiaryFragment(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        init(view);

        Diary diary1 = new Diary("2020.09.05", "집 가고 싶다", "요즘에는 집에 있는데도 집에 가고싶은 기분이다..");
        Diary diary2 = new Diary("2020.09.08", "오느른 내생일", "오늘은 드디어 내 생일이다. 생일인데 집에서 온라인 수업을 듣다니, 기숙사가 아닌걸 다해이라고 해야되나.");

        diaryList.add(diary1);
        diaryList.add(diary2);

        return view;
    }

    public void init(View view) {
        diaryRecyclerView = (RecyclerView) view.findViewById(R.id.diary_recyclerview);
        diaryTitle = (TextView) view.findViewById(R.id.diary_title);
    }
}