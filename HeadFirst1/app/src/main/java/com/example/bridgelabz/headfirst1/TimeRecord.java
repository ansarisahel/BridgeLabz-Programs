package com.example.bridgelabz.headfirst1;

/**
 * Created by bridgelabz on 6/1/16.
 */
public class TimeRecord {
    private String time;
    private String notes;

    TimeRecord(String time,String notes)
    {
        this.time = time;
        this.notes = notes;
    }

    public String getTime()
    {
        return time;
    }
    public void setTime(String time)
    {
        this.time = time;
    }
    public String getNotes()
    {
        return notes;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }
}
