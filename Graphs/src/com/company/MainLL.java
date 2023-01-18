package com.company;

import java.util.ArrayList;

public class MainLL {

    public static void main(String[] args) {
        ArrayList<GraphNodeLL> nodeList = new ArrayList<GraphNodeLL>();
        nodeList.add(new GraphNodeLL("A",0));
        nodeList.add(new GraphNodeLL("B",1));
        nodeList.add(new GraphNodeLL("C",2));
        nodeList.add(new GraphNodeLL("D",3));
        nodeList.add(new GraphNodeLL("E",4));
        nodeList.add(new GraphNodeLL("F",5));
        nodeList.add(new GraphNodeLL("G",6));
        nodeList.add(new GraphNodeLL("H",7));
        GraphLL graph = new GraphLL(nodeList);
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
