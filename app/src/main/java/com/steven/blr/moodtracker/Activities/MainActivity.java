package com.steven.blr.moodtracker.Activities;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;

import com.steven.blr.moodtracker.Fragments.ScreenSlidePageFragment;
import com.steven.blr.moodtracker.MoodHistory;
import com.steven.blr.moodtracker.R;
import com.steven.blr.moodtracker.Adapters.ScreenSlidePageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends FragmentActivity
{
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;

    // System
    private int[] imgRefs;
    private int nbFrag = 5;
    private static final String BUNDLE_KEY_CURRENT_MOOD = "currentMood";
    private Dictionary<Date,MoodHistory> keyDateMoodHistory;
    private SharedPreferences preferences;

    // UI
    public ImageButton historyBt;
    public ImageButton commentBt;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        //3 - Configure ViewPager
        this.configureViewPager();
        Log.d("MainActivity", "OnCreate");

        historyBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("MainActivity", "Click on History BT");
            }
        });

        commentBt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("MainActivity", "Click on Comment BT");
            }
        });


    }

    private void configureViewPager()
    {
        initImageRefs();
        // 1 - Get ViewPager from layout
        pager = findViewById(R.id.activity_main_viewpager);
        pagerAdapter = new ScreenSlidePageAdapter(this, getResources().getIntArray(R.array.colorPagesViewPager), imgRefs, nbFrag);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(3); // Happy mood

        // Listener - Call onPageSelected function when a new page is selected
        ViewPager2.OnPageChangeCallback listener = new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position)
            {
                super.onPageSelected(position);
                Log.d("MainActivity", "Switch position to " + position);
                //Bind current mood with current position
                MoodHistory.Mood currentMood = MoodHistory.Mood.values()[position];

                // Check if a mood is already store for today
                Date currentDate = Calendar.getInstance().getTime();
                // If true --> Create new mood with current one
                if (keyDateMoodHistory.get(currentDate) == null)
                {
                    MoodHistory newMH = new MoodHistory(currentMood);
                    keyDateMoodHistory.put(currentDate, newMH);
                    Log.d("MainActivity", "Added new mood " + currentMood.toString());
                }
                // else --> Modify last mood with current one
                else
                {
                    keyDateMoodHistory.get(currentDate).setMood(currentMood);
                    Log.d("MainActivity", "Modified today's mood to " + currentMood.toString());
                }
            }
        };
        pager.registerOnPageChangeCallback(listener);
    }

    private void initUI()
    {
        historyBt = findViewById(R.id.history_BT);
        commentBt = findViewById(R.id.mood_comment_BT);
    }

    @Override
    public void onBackPressed() {
        if (pager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        int currentPagerIndex = pager.getCurrentItem();
        outState.putInt(BUNDLE_KEY_CURRENT_MOOD, currentPagerIndex);

        super.onSaveInstanceState(outState);
    }

    private void initImageRefs()
    {
        imgRefs = new int[5];
        // TODO : Restructure
        imgRefs[0] = R.drawable.smiley_sad;
        imgRefs[1] = R.drawable.smiley_disappointed;
        imgRefs[2] = R.drawable.smiley_normal;
        imgRefs[3] = R.drawable.smiley_happy;
        imgRefs[4] = R.drawable.smiley_super_happy;
    }



}
