package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Activity> ActivityList = new ArrayList<>();

        ActivityList.add(new Activity("A1" , 0 , 6));
        ActivityList.add(new Activity("A2" , 3 , 4));
        ActivityList.add(new Activity("A3" , 1 , 2));
        ActivityList.add(new Activity("A4" , 5 , 8));
        ActivityList.add(new Activity("A5" , 5 , 7));
        ActivityList.add(new Activity("A6" , 8 , 9));
        ActivitySelection.activitySelection(ActivityList);
        // write your code here
    }
}
