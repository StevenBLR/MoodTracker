package com.steven.blr.moodtracker;

import android.util.Log;

import java.util.Date;

/**
 * Created by Steven - on 01/05/2020
 */

public class MoodHistory
{
    public enum Mood {Sad, Disappointed, Normal, Happy, SuperHappy}
    private Mood mood;
    private String comment;
    private int id;

    public MoodHistory(Mood mood)
    {
        this.mood = mood;
        id = this.hashCode();
        Log.d("MoodHistory", "new Mood History " + id);
    }

    public void setMood(Mood newMood)
    {
        mood = newMood;
    }

    public Mood getMood()
    {
        return mood;
    }

    public void setComment(String newComment) { comment = newComment; }

    public String getComment() { return comment; }
}
