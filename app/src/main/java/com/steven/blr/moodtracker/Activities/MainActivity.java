package com.steven.blr.moodtracker.Activities;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.steven.blr.moodtracker.Fragments.ScreenSlidePageFragment;
import com.steven.blr.moodtracker.R;
import com.steven.blr.moodtracker.Adapters.ScreenSlidePageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends FragmentActivity
{
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;
    private int[] imgRefs;
    private int nbFrag = 5;
    private static final String BUNDLE_KEY_CURRENT_MOOD = "currentMood";

    // UI
    public ImageButton historyBt;
    public ImageButton commentBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }

    private void configureViewPager()
    {
        initImageRefs();
        // 1 - Get ViewPager from layout
        pager = findViewById(R.id.activity_main_viewpager);
        pagerAdapter = new ScreenSlidePageAdapter(this, getResources().getIntArray(R.array.colorPagesViewPager), imgRefs, nbFrag);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(3); // Happy mood

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
