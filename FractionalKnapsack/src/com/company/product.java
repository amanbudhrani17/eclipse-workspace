package com.company;

public class product {
    String name;
    double value;
    double weight;
    double density;
    public product(String name, double value, double weight){
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.density = value/weight;
    }
}
