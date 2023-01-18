package com.company;

public class Activity {
    public String name;
    public int startTime;
    public int finishTime;

    public Activity(String name, int startTime, int finishTime){
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
    @Override
    public String toString(){
        return this.name + " from " + this.startTime + " to " + this.finishTime;
    }
}
