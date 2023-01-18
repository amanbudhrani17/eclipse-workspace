package com.company;

import java.util.ArrayList;

public class DisjointSet {
    private ArrayList<WeightNode> nodeList = new ArrayList<>();
    public static void makeSet(ArrayList<WeightNode> nodeList){
        for (WeightNode node : nodeList){
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }
    public static DisjointSet findSet(WeightNode node) {
        return node.set;
    }
    public static DisjointSet Union(WeightNode node1, WeightNode node2) {
        if (node1.set.equals(node2.set)) {
            return null;
        } else {
            DisjointSet set1 = node1.set;
            DisjointSet set2 = node2.set;
//            if (set1.nodeList.size()>set2.nodeList.size()){
//                for (WeightNode node : set2.nodeList){
////                    node.set = set1;
//                    set1.nodeList.add(node);
//                }
//                return set1;
//            }
//            else {
            for (WeightNode node : set1.nodeList) {
//                    node.set = set2;
                set2.nodeList.add(node);
            }
            for (WeightNode node : node1.set.nodeList) {
                node.set = set2;
            }
            for (WeightNode node : node2.set.nodeList) {
                node.set = set2;
            }
            return set2;
        }
//    }
    }
    public void printAllNodesOfThisSet() {
        System.out.println("Printing all nodes of the set: ");
        for (WeightNode node : nodeList ) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

}

