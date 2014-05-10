package com.nickotter.cleanyourshit.app.helpers;

import android.app.ActionBar;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

/**
 * A set of functions to help with action bar actions
 */
public class ActionBarHelper {

    /**
     * Prepares a correctly colored ArrayAdapter for a given theme
     *
     * @param activity
     * @param items
     */
    public static ArrayAdapter<String> provideNavigationAdapter(Activity activity, String[] items) {

        ActionBar actionBar = activity.getActionBar();

        if (actionBar != null) {

            return new ArrayAdapter<String>(
                    actionBar.getThemedContext() != null ? actionBar.getThemedContext() : activity,
                    android.R.layout.simple_list_item_1,
                    items
            );

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

    public static boolean setNavigationSelected(Activity activity, ArrayAdapter<String> adapter, String selected)
    {

        ActionBar actionBar = activity.getActionBar();

        if (actionBar != null) {

            int setPosition = adapter.getPosition(selected);
            actionBar.setSelectedNavigationItem(setPosition);

            return true;

        }

        return false;
    }

}
