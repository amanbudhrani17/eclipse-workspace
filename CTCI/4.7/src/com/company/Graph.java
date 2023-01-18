package com.company;

import java.util.*;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    HashMap<String, GraphNode> map = new HashMap<>();
    int[][] adjacencyMatrix;
    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
        for (GraphNode node: nodeList){
            map.put(node.name, node);
        }
    }
    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbour = new ArrayList<GraphNode>();
        int index = node.index;
        for (int i = 0; i<adjacencyMatrix.length; i++){
            if (adjacencyMatrix[index][i]==1){
                neighbour.add(nodeList.get(i));
            }
        }
        return neighbour;
    }

    void addDirectedEdge(String p1, String p2){
        int i = map.get(p1).index;
        int j = map.get(p2).index;

        adjacencyMatrix[i][j] = 1;
        nodeList.get(j).dependencies++;
    }

    private void pathPrint(GraphNode node){
        while (node.parent!= null) {
            System.out.print(node.name + " -> ");
            node = node.parent;
        }
        System.out.print(node.name);
    }
}
