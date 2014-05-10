package com.nickotter.cleanyourshit.app.helpers;

import android.content.Context;

import com.nickotter.cleanyourshit.app.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Functions to access Chores string resources
 */
public class ChoresResources {

    private static String[] getSpecificChores(Context context, String day) {

        List<String> days = Arrays.asList(context.getResources().getStringArray(R.array.days));
        int dayIndex = days.indexOf(day);

        switch (dayIndex) {

            case 1: //MONDAY
            case 2: //TUESDAY
            case 3: //WEDNESDAY
            case 4: //THURSDAY:

                return ResourceHelper.string2dArray(context, "chores", dayIndex);

            default:
                return new String[0];

        }

    }

    private static String[] getDailyChores(Context context) {
        return context.getResources().getStringArray(R.array.chores_default);
    }

    public static List<ChoresWrapper> getListForDay(Context context, String day) {

        List<ChoresWrapper> chores = new ArrayList<ChoresWrapper>();

        String[] specificChores = getSpecificChores(context, day);
        Arrays.sort(specificChores);

        String[] dailyChores = getDailyChores(context);
        Arrays.sort(dailyChores);

        for(String chore : specificChores) {
            chores.add(new ChoresWrapper(day, chore));
        }

        for(String chore : dailyChores) {
            chores.add(new ChoresWrapper(null, chore));
        }

        return chores;

    }

}
