package com.nickotter.cleanyourshit.app.helpers;

/**
 * Created by otternq on 5/7/14.
 */
public class ChoresWrapper implements Comparable<ChoresWrapper> {

    public String day;
    public String chore;

    public ChoresWrapper(String day, String chore)
    {
        this.day  = day;
        this.chore = chore;
    }

    public int compareTo(ChoresWrapper compareChore) {

        return chore.compareTo(compareChore.chore);

    }

}
