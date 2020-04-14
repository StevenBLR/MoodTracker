package com.steven.blr.moodtracker.Activities;

/**
 * Created by Steven - on 14/04/2020
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.steven.blr.moodtracker.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}

