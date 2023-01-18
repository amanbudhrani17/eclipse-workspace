package com.company;
import java.util.*;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }
    void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbor : currentNode.neighbors) {
                if(queue.contains(neighbor)) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }
    public static void pathPrint(WeightedNode node) {
        if (node.parent  != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }
    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second,d);
    }
    void floydWarshall() {
        int size = nodeList.size();
        int[][] V = new int[size][size];

        // Initializing Distance table from adjacency list
        for (int i = 0; i < size; i++) {
            WeightedNode first = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                if (i == j)
                    V[i][j] = 0;
                else if (first.weightMap.containsKey(second)) { //we have direct edge between i & j
                    V[i][j] = first.weightMap.get(second);
                } else { //no direct edge between i & j, so mark it as infinity [divided by 10 to avoid arithmetic overflow]
                    V[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }//end of loop


        // Floyd Warshall's Algorithm
        for (int k = 0; k < nodeList.size(); k++) {
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if (V[i][j] > V[i][k] + V[k][j]) {  // if update possible, then update path
                        V[i][j] = V[i][k] + V[k][j];    // this will keep a track on path
                    }
                    if(i==1&&j==3){
                        System.out.println(V[i][k]+V[k][j]);
                    }
                }
            }
        }//end of loop


        // Print table of node with minimum distance and shortest path from each source
        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
            for (int j = 0; j < size; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }
}
