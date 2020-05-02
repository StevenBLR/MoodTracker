package com.steven.blr.moodtracker;

import android.util.Log;

import java.util.Date;

/**
 * Created by Steven - on 01/05/2020
 */

public class MoodHistory
{
    public enum Mood {None, Sad, Disappointed, Normal, Happy, SuperHappy}
    private Mood mood;
    private Date creationDate;
    private int id;

    public MoodHistory(Mood mood, Date creationDate)
    {
        this.mood = mood;
        this.creationDate = creationDate;
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
}
