package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<product> products = new ArrayList<>();
        products.add(new product("a1", 22, 9));
        products.add(new product("a2", 30, 5));
        products.add(new product("a3", 10, 3));
        products.add(new product("a4", 22, 9));
        products.add(new product("a5", 10, 10));
        products.add(new product("a6", 30, 10));
        double i = FractionalKnapsack.fractionalKnapsack(products,30);
        System.out.println(i);
    }
}
