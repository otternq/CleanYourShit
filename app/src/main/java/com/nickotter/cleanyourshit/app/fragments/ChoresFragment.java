package com.nickotter.cleanyourshit.app.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.nickotter.cleanyourshit.app.R;

/**
 * A basic fragment to display a list of chores
 */
public class ChoresFragment extends Fragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.chores_main, container, false);

        if (rootView != null) {
            list = (ListView) rootView.findViewById(R.id.chores);
        }

        return rootView;
    }

    public void setChoresAdapter(ListAdapter adapter)
    {
        if (list != null) {
            list.setAdapter(adapter);
        }
    }

}
