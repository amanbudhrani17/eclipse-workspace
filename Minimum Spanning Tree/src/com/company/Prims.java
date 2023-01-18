package com.company;

import java.util.*;

public class Prims {
    ArrayList<WeightNode> nodeList = new ArrayList<>();
    public Prims(ArrayList<WeightNode> nodeList){
        this.nodeList = nodeList;
    }
    public void addWeightedUndirectedEdge(int i, int j, int d){
        WeightNode first = nodeList.get(i);
        WeightNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second,d);
        second.weightMap.put(first,d);
    }
    void prims(WeightNode node){
        for (int i = 0; i<nodeList.size(); i++){
            nodeList.get(i).distance = Integer.MAX_VALUE;
        }
        node.distance = 0;
        PriorityQueue<WeightNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while (!queue.isEmpty()){
            WeightNode currentNode = queue.remove();
            for (WeightNode neighbor : currentNode.neighbors){
                if (queue.contains(neighbor)){
                    if (neighbor.distance > currentNode.weightMap.get(neighbor)){
                        neighbor.distance = currentNode.weightMap.get(neighbor);
                        neighbor.parent=currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        int cost = 0;
        for (WeightNode node1 : nodeList){
            System.out.println("Node " + node1 + " key "+node1.distance + " Parent " + node1.parent);
            cost+=node1.distance;
        }
        System.out.println(cost);
    }
}
