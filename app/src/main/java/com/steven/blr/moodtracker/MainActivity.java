package com.steven.blr.moodtracker;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends FragmentActivity
{
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;
    private int[] imgRefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3 - Configure ViewPager
        this.configureViewPager();
        Log.d("MainActivity", "OnCreate");
    }

    private void configureViewPager(){
        initImageRefs();
        // 1 - Get ViewPager from layout
        pager = findViewById(R.id.activity_main_viewpager);
        pagerAdapter = new ScreenSlidePageAdapter(this, getResources().getIntArray(R.array.colorPagesViewPager), imgRefs);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(2);

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

    private void initImageRefs()
    {
        //Log.d("MainActivity", "Pager Width = " + pager.getAdapter().getItemCount());

        imgRefs = new int[5];

        imgRefs[0] = R.drawable.smiley_sad;
        imgRefs[1] = R.drawable.smiley_disappointed;
        imgRefs[2] = R.drawable.smiley_normal;
        imgRefs[3] = R.drawable.smiley_happy;
        imgRefs[4] = R.drawable.smiley_super_happy;
    }
}
