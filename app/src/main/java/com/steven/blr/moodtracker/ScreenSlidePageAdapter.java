package com.steven.blr.moodtracker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ScreenSlidePageAdapter extends FragmentStateAdapter {

    private int[] colors;

    public ScreenSlidePageAdapter(@NonNull FragmentActivity fragmentActivity, int[] colors) {
        super(fragmentActivity);
        this.colors = colors;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ScreenSlidePageFragment.newInstance(position, this.colors[position]);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}