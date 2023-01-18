package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));
        nodeList.add(new GraphNode("F",5));
        nodeList.add(new GraphNode("G",6));
        nodeList.add(new GraphNode("H",7));
        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0,2);
        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,3);
        graph.addUndirectedEdge(2,4);
        graph.addUndirectedEdge(3,5);
        graph.addUndirectedEdge(4,7);
        graph.addUndirectedEdge(4,5);
        graph.addUndirectedEdge(5,6);
        System.out.println(graph.toString());
//       graph.topologicalSort();
        graph.BFSForSssp(nodeList.get(0), nodeList.get(6));
    }
}
