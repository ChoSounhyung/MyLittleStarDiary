package com.mirinae.mylittlestardiary;

public class Diary {

    private int id;
    private String date;
    private String title;
    private String contents;

    // Constructor
    public Diary(String date, String title, String contents) {
        this.date = date;
        this.title = title;
        this.contents = contents;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() { return contents; }

    public void setContents(String contents) { this.contents = contents; }
}
