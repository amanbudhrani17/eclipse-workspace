package com.company;

import java.util.*;

public class WeightNode implements Comparable<WeightNode>{
    public String name;
    public int distance;
    public ArrayList<WeightNode> neighbors = new ArrayList<>();
    public HashMap<WeightNode, Integer> weightMap = new HashMap();
    public boolean isVisited = false;
    public WeightNode parent;
//    public int index;
    public DisjointSet set;

    public WeightNode(String name){
        this.name = name;
        distance = Integer.MAX_VALUE;
//        this.index = index;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(WeightNode o) {
        return this.distance - o.distance;
    }
}
