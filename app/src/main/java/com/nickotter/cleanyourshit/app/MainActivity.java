package com.nickotter.cleanyourshit.app;

import android.app.Activity;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.nickotter.cleanyourshit.app.fragments.ChoresFragment;
import com.nickotter.cleanyourshit.app.helpers.Chores;


public class MainActivity extends Activity implements ActionBar.OnNavigationListener {

    protected ArrayAdapter<String> dayAdaper;
    protected ChoresFragment choreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getActionBar();

        if (actionBar != null) {

            String[] days = getResources().getStringArray(R.array.days);

            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

            if (actionBar.getThemedContext() != null) {
                dayAdaper = new ArrayAdapter<String>(
                        actionBar.getThemedContext(),
                        android.R.layout.simple_list_item_1,
                        days
                );
            } else {
                dayAdaper = new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        days
                );
            }

            actionBar.setListNavigationCallbacks(dayAdaper, this);

        }

        choreFragment = new ChoresFragment();

        getFragmentManager().beginTransaction()
                .add(R.id.container, choreFragment)
                .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int position, long id) {

        String day = dayAdaper.getItem(position);

        choreFragment.setChoresWithWrapper(
                Chores.asWrapperForDay(this, day)
        );

        return true;

    }

}
