package com.steven.blr.moodtracker.Activities;

import android.os.Bundle;

import com.steven.blr.moodtracker.MoodHistory;
import com.steven.blr.moodtracker.R;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoodsHistoryActivity extends AppCompatActivity
{
    // UI
    private ListView listView;

    // System
    private List<MoodHistory> moodsHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods_history);
        listView = (ListView) findViewById(R.id.mood_history_list_view);
        // Fill history
        initMoodHistory();
    }



    // New Mood
    public void storeNewMood(MoodHistory.Mood newMood, Date moodDate)
    {

    }

    // Update Mood
    public void updateCurrentMood(MoodHistory.Mood newMood)
    {

    }

    private void initMoodHistory()
    {
        // Get stored moods count
        int lastStoredMoods;
    }
}
