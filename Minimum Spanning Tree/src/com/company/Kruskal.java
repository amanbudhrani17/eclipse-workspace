package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
    ArrayList<WeightNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();
    public Kruskal(ArrayList<WeightNode> nodeList){
        this.nodeList = nodeList;
    }
    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight){
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        WeightNode first = edge.first;
        WeightNode second = edge.second;
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }
    void kruskal(){
        DisjointSet.makeSet(nodeList);
        Comparator<UndirectedEdge> comparator = new Comparator<>(){

            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2) {
                return o1.weight-o2.weight;
            }
        };
        Collections.sort(edgeList,comparator);
        int cost = 0;
        for (UndirectedEdge edge : edgeList){
            WeightNode first = edge.first;
            WeightNode second = edge.second;
            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
                DisjointSet.Union(first,second);
                cost+=edge.weight;
            }
        }
        System.out.print(cost);
    }

}
