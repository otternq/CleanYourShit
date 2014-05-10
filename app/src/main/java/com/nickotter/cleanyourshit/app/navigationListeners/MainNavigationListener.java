package com.nickotter.cleanyourshit.app.navigationListeners;

import android.app.ActionBar;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.nickotter.cleanyourshit.app.adapters.ChoresAdapter;
import com.nickotter.cleanyourshit.app.fragments.ChoresFragment;
import com.nickotter.cleanyourshit.app.helpers.Chores;

/**
 * Listens for Navigation and updates the Chores list
 */
public class MainNavigationListener implements ActionBar.OnNavigationListener {

    Context context;
    ChoresFragment choresFragment;
    ArrayAdapter<String> adapter;

    public MainNavigationListener(Context context, ChoresFragment cf, ArrayAdapter<String> adapter) {
        this.context = context;
        this.choresFragment = cf;
        this.adapter = adapter;
    }

    @Override
    public boolean onNavigationItemSelected(int position, long id) {

        String day = adapter.getItem(position);

        choresFragment.setChoresAdapter(
            new ChoresAdapter(
                    this.context,
                    Chores.asWrapperForDay(this.context, day)
            )
        );

        return true;

    }

}
