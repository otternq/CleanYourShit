package com.nickotter.cleanyourshit.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.nickotter.cleanyourshit.app.fragments.ChoresFragment;
import com.nickotter.cleanyourshit.app.helpers.ActionBarHelper;
import com.nickotter.cleanyourshit.app.navigationListeners.MainNavigationListener;


public class MainActivity extends Activity {
    protected ChoresFragment choreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choreFragment = new ChoresFragment();

        String[] days = getResources().getStringArray(R.array.days);

        ArrayAdapter<String> dayAdapter = ActionBarHelper.provideNavigationAdapter(
                this,
                days
        );

        if (dayAdapter != null) {

            ActionBarHelper.setNavigationList(
                this,
                dayAdapter,
                new MainNavigationListener(
                        this,
                        choreFragment,
                        dayAdapter
                )
            );

        }

        getFragmentManager().beginTransaction()
                .add(R.id.container, choreFragment)
                .commit();

    }

}
