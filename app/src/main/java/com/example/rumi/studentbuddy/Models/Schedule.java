package com.example.rumi.studentbuddy.Models;

public class Schedule {
    private String id;
    private String day;
    private String item;
    private String subject;
    private String time;

    public Schedule(String id, String day, String item, String subject, String time) {
        this.id = id;
        this.day = day;
        this.item = item;
        this.subject = subject;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
