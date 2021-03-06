package com.nickotter.cleanyourshit.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.nickotter.cleanyourshit.app.fragments.ChoresFragment;
import com.nickotter.cleanyourshit.app.helpers.ActionBarHelper;
import com.nickotter.cleanyourshit.app.helpers.DateHelper;
import com.nickotter.cleanyourshit.app.navigationListeners.MainNavigationListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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

            ActionBarHelper.setNavigationSelected(
                this,
                dayAdapter,
                DateHelper.getCurrentDayString()
            );

        }

        getFragmentManager().beginTransaction()
                .add(R.id.container, choreFragment)
                .commit();

    }

}
