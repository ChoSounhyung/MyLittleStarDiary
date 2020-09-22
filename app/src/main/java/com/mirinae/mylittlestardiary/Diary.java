package com.mirinae.mylittlestardiary;

public class Diary {

    private int diary_id;
    private String diary_day;
    private String title;
    private String content;

    // Constructor
    public Diary(String title, String diary_day) {
        this.diary_day = diary_day;
        this.title = title;
        this.content = content;
    }

    // getter and setter
    public int getDiary_id() {
        return diary_id;
    }

    public void setDiary_id(int diary_id) {
        this.diary_id = diary_id;
    }

    public String getDiary_day() { return diary_day; }

    public void setDiary_day(String diary_day) { this.diary_day = diary_day; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}
