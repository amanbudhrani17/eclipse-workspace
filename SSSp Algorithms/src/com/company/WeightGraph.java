package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class WeightGraph {
    ArrayList<WeightNode> nodeList = new ArrayList<>();
    public WeightGraph(ArrayList<WeightNode> nodeList){
        this.nodeList = nodeList;
    }
    private void pathPrint(WeightNode node){
        ArrayList<WeightNode> nodel = new ArrayList<>();
        String s = node.name;
        while (node.parent!= null) {
            nodel.add(node.parent);
//            System.out.print(node.name + " -> ");
            node = node.parent;
        }
//      nodel.add(node);
        Collections.reverse(nodel);
        for (WeightNode n : nodel){
            System.out.print(n.name + " -> ");
        }
        System.out.println(s);
    }
    void dijkstra(WeightNode node, WeightNode node2){
        PriorityQueue<WeightNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()){
            WeightNode currentNode = queue.remove();
//            System.out.println(currentNode.name);
            if (node2.name == currentNode.name){
                System.out.println("Printing Cheapest Path from " + node + " to " + node2);
                pathPrint(currentNode);
                System.out.println("price is " + currentNode.distance);
                return;
            }
            for (WeightNode neighbour : currentNode.neighbors) {
                if (queue.contains(neighbour)) {
                    if (neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = currentNode.distance + currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }
    }
    public void addWeightEdge(int i, int j, int k){
        WeightNode first = nodeList.get(i);
        WeightNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, k);
//        second.weightMap.put(first, k);
    }
    void bellmanFord(WeightNode sourceNode) {
        sourceNode.distance = 0;
        for (int i=0; i<nodeList.size(); i++) {
            for (WeightNode currentNode : nodeList) {
                for (WeightNode neighbor : currentNode.neighbors) {
                    if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
                        neighbor.parent = currentNode;
                    }
                }
            }
        }
        System.out.println("Checking for Negative Cycle..");
        for (WeightNode currentNode : nodeList) {
            for (WeightNode neighbor : currentNode.neighbors ) {
                if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex name: " + neighbor.name);
                    System.out.println("Old cost: " + neighbor.distance);
                    int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
                    System.out.println("new cost: " + newDistance);
                    return;
                }
            }
        }
        System.out.println("Negative Cycle not found");

        for (WeightNode nodeToCheck : nodeList) {
            System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }
    public void FloydWarshall(int a, int b){
        int size = nodeList.size();
        int[][] V = new int[size][size];
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                if (i == j){
                    V[i][j] = 0;
                }
                else if (nodeList.get(i).weightMap.containsKey(nodeList.get(j))){
                    V[i][j] = nodeList.get(i).weightMap.get(nodeList.get(j));
                }
                else V[i][j] = Integer.MAX_VALUE/10;
            }
        }
        for (int k = 0; k<size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (V[i][j] > V[i][k] + V[k][j]) {
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for node "+nodeList.get(i)+": ");
            for (int j = 0; j < size; j++) {
                System.out.print(V[i][j]+" ");
            }
            System.out.println();
        }
    }
}
