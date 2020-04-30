package com.steven.blr.moodtracker;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ScreenSlidePageAdapter extends FragmentStateAdapter {

    private int[] colors;
    private int[] moodRefs;

    public ScreenSlidePageAdapter(@NonNull FragmentActivity fragmentActivity, int[] colors, int[] imgs) {
        super(fragmentActivity);
        this.colors = colors;
        this.moodRefs = imgs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d("Adapter", "Create Fragment with position " + position);
        return ScreenSlidePageFragment.newInstance(position, this.colors[position], this.moodRefs[position]);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}