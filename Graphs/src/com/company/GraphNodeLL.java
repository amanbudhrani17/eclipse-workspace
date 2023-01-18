package com.company;

import java.util.ArrayList;

public class GraphNodeLL {
    public String name;
    public int index;

    public ArrayList<GraphNodeLL> neighbors= new ArrayList<GraphNodeLL>();
    public boolean isVisited;
    GraphNodeLL parent = null;
    public GraphNodeLL(String name, int index){
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }
}
