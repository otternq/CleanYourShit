package com.nickotter.cleanyourshit.app.helpers;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;

import com.nickotter.cleanyourshit.app.MainActivity;
import com.nickotter.cleanyourshit.app.fragments.ChoresFragment;
import com.nickotter.cleanyourshit.app.navigationListeners.MainNavigationListener;

/**
 * A set of functions to help with action bar actions
 */
public class ActionBarHelper {

    /**
     *
     * @param activity
     * @param items
     * @return
     */
    public static ArrayAdapter<String> provideNavigationAdapter(Activity activity, String[] items) {

        ActionBar actionBar = activity.getActionBar();

        if (actionBar != null) {

            ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(
                    actionBar.getThemedContext() != null ? actionBar.getThemedContext() : activity,
                    android.R.layout.simple_list_item_1,
                    items
            );

            return itemsAdapter;

        }

        return null;
    }

    public static boolean setNavigationList(Activity activity, SpinnerAdapter adapter, ActionBar.OnNavigationListener listener)
    {

        ActionBar actionBar = activity.getActionBar();

        if (actionBar != null) {

            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

            actionBar.setListNavigationCallbacks(
                    adapter,
                    listener
            );

            return true;

        }

        return false;

    }

}
