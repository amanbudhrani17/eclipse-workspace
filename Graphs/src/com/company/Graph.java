package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;
    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
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
    void bfs(GraphNode node){
        Queue<GraphNode> queue =new LinkedList<GraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode current = queue.remove();
            current.isVisited = true;
            System.out.print(current.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbors(current);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }
    public void bfs(){
        for (GraphNode node : nodeList){
            if (!node.isVisited) bfs(node);
        }
    }
    void dfs(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode current = stack.pop();
            current.isVisited = true;
            System.out.print(current.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbors(current);
            for (GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }
    public void dfs(){
        for (GraphNode node : nodeList){
            if (!node.isVisited) dfs(node);
        }
    }
    void addDirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = 1;
    }
    void topologicalSort(GraphNode node, Stack<GraphNode> stack){
        ArrayList<GraphNode> neighbours = getNeighbors(node);
        for(GraphNode neighbour : neighbours){
            if(!neighbour.isVisited) {
                topologicalSort(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }
    public void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList){
            if (!node.isVisited) topologicalSort(node, stack);
        }
        while (!stack.isEmpty()) System.out.print(stack.pop().name + " ");
    }
    private void pathPrint(GraphNode node){
        while (node.parent!= null) {
            System.out.print(node.name + " -> ");
            node = node.parent;
        }
        System.out.print(node.name);
    }
    public void BFSForSssp(GraphNode node2, GraphNode node){
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            if(currentNode.name == node2.name){
                System.out.println("Printing path from " + node2.name + " to " + node.name);
                pathPrint(currentNode);
            }
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors){
                if (!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;

                }
            }
        }
    }

}
