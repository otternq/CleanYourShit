package com.nickotter.cleanyourshit.app.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nickotter.cleanyourshit.app.R;
import com.nickotter.cleanyourshit.app.helpers.ChoresWrapper;

import java.util.List;

/**
 * Created by otternq on 5/7/14.
 */
public class ChoresAdapter extends ArrayAdapter<ChoresWrapper> {

    public ChoresAdapter(Context context, List<ChoresWrapper> chores) {
        super(context, R.layout.activity_main, chores);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        ChoresWrapper chore = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.chore, null);
        }

        TextView typeTextView  = (TextView) convertView.findViewById(R.id.type);
        TextView choreTextView = (TextView) convertView.findViewById(R.id.chore);

        int textColorId;
        int backgroundColorId;

        if (chore.day != null) {
            typeTextView.setText(chore.day.toString().toUpperCase());

            textColorId = R.color.chores_list_specific_text;
            backgroundColorId = R.color.chores_list_specific_background;
        } else {
            typeTextView.setText(R.string.chores_list_daily);

            textColorId = R.color.chores_list_daily_text;
            backgroundColorId = R.color.chores_list_daily_background;
        }

        int textColor = getContext().getResources().getColor(textColorId);
        int backgroundColor = getContext().getResources().getColor(backgroundColorId);

        typeTextView.setTextColor(textColor);
        typeTextView.setBackgroundColor(backgroundColor);

        choreTextView.setText(chore.chore);

        // Return the completed view to render on screen
        return convertView;

    }

}
