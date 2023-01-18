package com.company;

public class GraphNode {
    String name;
    int index;
    int dependencies = 0;
    GraphNode parent = null;
    public GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }
}
