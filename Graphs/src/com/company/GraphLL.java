package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphLL {
    ArrayList<GraphNodeLL> nodeList = new ArrayList<GraphNodeLL>();
     public GraphLL(ArrayList<GraphNodeLL> nodeList){
         this.nodeList = nodeList;
     }

     public void addUndirectedEdge(int i , int j){
         GraphNodeLL first = nodeList.get(i);
         GraphNodeLL second = nodeList.get(j);
         first.neighbors.add(second);
         second.neighbors.add(first);
     }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size()-1 ) {
                    s.append((nodeList.get(i).neighbors.get(j).name) );
                } else {
                    s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
    void topologicalSort(GraphNodeLL node, Stack<GraphNodeLL> stack){
        for(GraphNodeLL neighbour : node.neighbors){
            if(!neighbour.isVisited) {
                topologicalSort(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }
    public void topologicalSort(){
        Stack<GraphNodeLL> stack = new Stack<>();
        topologicalSort(nodeList.get(0), stack);
        while (!stack.isEmpty()) System.out.print(stack.pop().name + " ");
    }
    private void pathPrint(GraphNodeLL node){
        while (node.parent!= null) {
            System.out.print(node.name + " -> ");
            node = node.parent;
        }
        System.out.print(node.name);
    }
    public void BFSForSssp(GraphNodeLL node2, GraphNodeLL node){
        Queue<GraphNodeLL> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNodeLL currentNode = queue.remove();
            currentNode.isVisited = true;
            if (currentNode.name == node2.name){
                System.out.println("Printing path from " + node2.name + " to " + node.name);
                pathPrint(currentNode);
            }
            for (GraphNodeLL neighbour : currentNode.neighbors){
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
            }
        }
    }
}
