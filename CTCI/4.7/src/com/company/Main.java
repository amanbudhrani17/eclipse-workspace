package com.company;

import java.util.ArrayList;

public class
Main {

    public static void main(String[] args) {
        String[] project = new String[]{"a","b","c","d","e","f"};
        String[][] dependencies = new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};
        for (GraphNode node: findBuildOrder(project,dependencies)){
            System.out.println(node.name);
        }
    }
    public static GraphNode[] findBuildOrder(String[] projectsGiven, String[][] dependencies){
        ArrayList<GraphNode> project = new ArrayList<>();
        for (int i = 0;i< projectsGiven.length;i++) {
            project.add(new GraphNode(projectsGiven[i],i));
        }
        Graph graph = new Graph(project);
        for (int i = 0; i < dependencies.length; i++){
            graph.addDirectedEdge(dependencies[i][0],dependencies[i][1]);
        }
        GraphNode[] order = new GraphNode[projectsGiven.length];
        int end = addNonDependent(order,project,0);
        int index = 0;
        while (index<order.length){
            GraphNode current = order[index];
            if (current == null){
                return null;
            }
            ArrayList<GraphNode> children = graph.getNeighbors(current);
            for (GraphNode child : children){
                child.dependencies--;
            }
            end = addNonDependent(order,children,end);
            index++;
        }
        System.out.println(graph.toString());
        return order;
    }
    private static int addNonDependent(GraphNode[] order, ArrayList<GraphNode> project, int offset){
        for (GraphNode node: project){
            if(node.dependencies == 0){
                order[offset] = node;
                offset++;
            }
        }
        return offset;
    }
}
