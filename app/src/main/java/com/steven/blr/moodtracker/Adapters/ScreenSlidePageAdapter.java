package com.steven.blr.moodtracker.Adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.steven.blr.moodtracker.Fragments.ScreenSlidePageFragment;

public class ScreenSlidePageAdapter extends FragmentStateAdapter {

    private int[] colors;
    private int[] moodRefs;
    private int nbFrag;

    public ScreenSlidePageAdapter(@NonNull FragmentActivity fragmentActivity, int[] colors, int[] imgs, int nbFrag) {
        super(fragmentActivity);
        this.colors = colors;
        this.moodRefs = imgs;
        this.nbFrag = nbFrag;
    }

    @NonNull
    @Override
    // Called when a new fragment is created
    // 3 frag in memory (default) - called whenever view buffer need to be uptaded with a new view)
    public Fragment createFragment(int position) {
        Log.d("Adapter", "Create Fragment with position " + position);
        return ScreenSlidePageFragment.newInstance(position, this.colors[position], this.moodRefs[position]);
    }

    @Override
    public int getItemCount() {
        return nbFrag;
    }
}