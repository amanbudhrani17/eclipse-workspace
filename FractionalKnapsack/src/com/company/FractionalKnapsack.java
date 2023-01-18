package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {
    public static double fractionalKnapsack(ArrayList<product> products, double max){
        Comparator<product> comparator = new Comparator<product>() {
            @Override
            public int compare(product o1, product o2) {
                return (int) (o1.density-o2.density);
            }
        };
        products.sort(comparator);
        Collections.reverse(products);
        double space = max;
        double value = 0;
        int i = 0;
        while (space>0){
            if(space>products.get(i).weight){
                space = space-products.get(i).weight;
                value+= products.get(i).value;
            }
            else {
                value+= space*products.get(i).density;
                space = 0;
            }
            i++;
        }
        return value;
    }
}
