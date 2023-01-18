package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {
    static void activitySelection(ArrayList<Activity> ActivityList) {
        Comparator<Activity> comparator = new Comparator<>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.finishTime - o2.finishTime;
            }
        };
        Collections.sort(ActivityList,comparator);
        Activity prev = ActivityList.get(0);
        System.out.println(prev);
        for (Activity next : ActivityList){
            if (next==prev) continue;
            if (next.startTime> prev.finishTime){
                System.out.println(next);
                prev = next;
            }
        }
    }
}
