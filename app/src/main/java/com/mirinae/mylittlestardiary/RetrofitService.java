package com.mirinae.mylittlestardiary;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    String URL = "http://13.209.41.209:53927";

    @GET("/app_diary/diary_list/{diary_id}")
    Call<Diary> getDiary(@Path("diary_id") String diaryId);

    @GET("/app_diary/diary_list")
    Call<List<Diary>> getDiaryList();


    @FormUrlEncoded
    @POST("/app_diary/diary_list")
    Call<Diary> postDiary(@FieldMap HashMap<String, Object> param);
}
