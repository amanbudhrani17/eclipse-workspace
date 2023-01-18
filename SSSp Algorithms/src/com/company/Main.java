package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
//        nodeList.add(new WeightNode("E", 4));
//        nodeList.add(new WeightNode("F", 5))
//        nodeList.add(new WeightNode("G", 6));
        WeightedGraph Graph = new WeightedGraph(nodeList);
        Graph.addWeightedEdge(1,0,1);
        Graph.addWeightedEdge(1,2,1);
        Graph.addWeightedEdge(2,3,1);
//        Graph.addWeightedEdge(2,0,4);
//        Graph.addWeightedEdge(3,1,2);
//        Graph.addWeightedEdge(3,2,9);
//        Graph.addWeightEdge(3,4,4);
//        Graph.addWeightEdge(4,6,9);
//        Graph.addWeightEdge(5,6,7);
        Graph.dijkstra(nodeList.get(1));
    }
}
