package com.company;

import java.security.PublicKey;

public class UndirectedEdge {
    public WeightNode first;
    public WeightNode second;
    public int weight;
    public UndirectedEdge(WeightNode first, WeightNode second, int weight){
        this.first=first;
        this.second=second;
        this.weight=weight;
    }
    @Override
    public String toString(){
        return "Edge (" + first +","+ second +") weight =" + weight;
    }
}
