package com.nickotter.cleanyourshit.app.helpers;

import android.content.Context;

/**
 * Created by otternq on 5/7/14.
 */
public class ResourceHelper {

    /**
     * Loads string-array resources in for form {prefix}_{index}
     *
     * @param context
     * @param prefix
     * @param index
     * @return An array of strings from strings.xml
     */
    public static String[] string2dArray(Context context, String prefix, int index)
    {

        String idString = prefix + "_" + index;

        int id = context.getResources().getIdentifier(idString, "array", context.getPackageName());
        return context.getResources().getStringArray(id);

    }

}
