package com.steven.blr.moodtracker.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.steven.blr.moodtracker.Fragments.PageFragment;

/**
 * Created by Steven - on 14/04/2020
 */

public class PageAdapter extends FragmentPagerAdapter
{
    // 1 - Array of colors that will be passed to PageFragment
    private int[] colors;

    // 2 - Default Constructor
    public PageAdapter(FragmentManager mgr, int[] colors)
    {
        super(mgr);
        this.colors = colors;
    }

    @Override
    public int getCount()
    {
        return(5); // 3 - Number of page to show
    }

    @Override
    public Fragment getItem(int position)
    {
        // 4 - Page to return
        return(PageFragment.newInstance(position, this.colors[position]));
    }
}
