package com.steven.blr.moodtracker;

/**
 * Created by Steven - on 21/04/2020
 */
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


public class ScreenSlidePagerActivity extends FragmentActivity
{
    // View Pager Widget - handles animation and allows swiping horizontally to access previous and next wizard steps.
    private ViewPager2 viewPager;

    // Pager adapter - provides the pages to the view pager widget
    private FragmentStateAdapter pagerAdapter;

    // 1 - Array of colors
    private int[] colors;
    private static final int NUM_PAGES = 5;

    // 2 - Default Constructor
    public ScreenSlidePagerActivity(int[] colors)
    {
        this.colors = colors;
    }

    public int getCount()
    {
        return(5); // 3 - Number of page to show
    }

    public FragmentStateAdapter getPageAdapter()
    {
        return pagerAdapter;
    }

    public Fragment getItem(int position)
    {
        // 4 - Page to return
        return(ScreenSlidePageFragment.newInstance(position, this.colors[position]));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
