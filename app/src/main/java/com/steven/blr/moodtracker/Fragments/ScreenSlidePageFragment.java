package com.steven.blr.moodtracker.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.steven.blr.moodtracker.R;

/**
 * Created by Steven - on 21/04/2020
 */

public class ScreenSlidePageFragment extends Fragment
{
    // 1 - Create keys for our Bundle
    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";
    private static final String KEY_MOOD="moodName";


    // 2 - Method that will create a new instance of PageFragment, and add data to its bundle.
    public static ScreenSlidePageFragment newInstance(int position, int color, int moodRef)
    {
        // 2.1 Create new fragment
        ScreenSlidePageFragment frag = new ScreenSlidePageFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        args.putInt(KEY_MOOD, moodRef);


        frag.setArguments(args);

        return(frag);
    }

    // Called whenever we need to instanciate a new Slide Page
    // Bundle contain our new instance -->
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // 3 - Get layout of PageFragment
        View result = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        // 4 - Get widgets to modify from layout
        LinearLayout rootView= (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        ImageView imageView= (ImageView) result.findViewById(R.id.mood_smiley);

        // 5 - Get data from Bundle (created in method newInstance) / getArguments() is a Fragment function
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);
        int moodId = getArguments().getInt(KEY_MOOD, -1);

        Log.d("Fragment", "stored position =" + position);
        Log.d("Fragment", "store color =" + color);

        // 6 - Update widgets with it
        rootView.setBackgroundColor(color);
        imageView.setImageResource(moodId);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }



}
