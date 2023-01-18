package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        ArrayList<WeightNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightNode("A"));
        nodeList.add(new WeightNode("B"));
        nodeList.add(new WeightNode("C"));
        nodeList.add(new WeightNode("D"));
        nodeList.add(new WeightNode("E"));
//        Kruskal kruskal = new Kruskal(nodeList);
//        kruskal.addWeightedUndirectedEdge(0,1,5);
//        kruskal.addWeightedUndirectedEdge(0,2,13);
//        kruskal.addWeightedUndirectedEdge(0,4,15);
//        kruskal.addWeightedUndirectedEdge(1,2,10);
//        kruskal.addWeightedUndirectedEdge(1,3,8);
//        kruskal.addWeightedUndirectedEdge(2,3,6);
//        kruskal.addWeightedUndirectedEdge(2,4,20);
//        kruskal.kruskal();
        Prims prims = new Prims(nodeList);
        prims.addWeightedUndirectedEdge(0,1,5);
        prims.addWeightedUndirectedEdge(0,2,13);
        prims.addWeightedUndirectedEdge(0,4,15);
        prims.addWeightedUndirectedEdge(1,2,10);
        prims.addWeightedUndirectedEdge(1,3,8);
        prims.addWeightedUndirectedEdge(2,3,6);
        prims.addWeightedUndirectedEdge(2,4,20);
        prims.prims(nodeList.get(3));
    }
}
