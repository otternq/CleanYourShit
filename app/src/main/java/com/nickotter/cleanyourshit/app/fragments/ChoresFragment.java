package com.nickotter.cleanyourshit.app.fragments;

/**
 * Created by otternq on 5/7/14.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nickotter.cleanyourshit.app.R;
import com.nickotter.cleanyourshit.app.adapters.ChoresAdapter;
import com.nickotter.cleanyourshit.app.helpers.ChoresWrapper;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChoresFragment extends Fragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.chores_main, container, false);

        list = (ListView) rootView.findViewById(R.id.chores);

        return rootView;
    }

    public void setChoresWithString(List<String> chores)
    {

        list.setAdapter(
                new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        chores
                )
        );

    }

    public void setChoresWithWrapper(List<ChoresWrapper> chores)
    {

        list.setAdapter(
                new ChoresAdapter(getActivity(), chores)
        );

    }
}
