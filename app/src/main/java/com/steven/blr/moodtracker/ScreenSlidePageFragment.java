package com.steven.blr.moodtracker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Created by Steven - on 21/04/2020
 */

public class ScreenSlidePageFragment extends Fragment
{
    // 1 - Create keys for our Bundle
    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";

    // 2 - Method that will create a new instance of PageFragment, and add data to its bundle.
    public static ScreenSlidePageFragment newInstance(int position, int color)
    {
        // 2.1 Create new fragment
        ScreenSlidePageFragment frag = new ScreenSlidePageFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
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
        TextView textView= (TextView) result.findViewById(R.id.fragment_page_title);

        // 5 - Get data from Bundle (created in method newInstance) / getArguments() is a Fragment function
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);


        // 6 - Update widgets with it
        rootView.setBackgroundColor(color);
        textView.setText("Page numéro "+ position);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }



}
