package com.company;

public class GraphNode {
    String name;
    int index;
    public boolean isVisited = false;
    GraphNode parent = null;
    public GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }
}
