package com.company;


public class Main {
    public static void main(String[] args){
        LinearProbing linearProbing = new LinearProbing(3);
        linearProbing.insert("The");
        linearProbing.insert("quick");
        linearProbing.insert("brown");
       // linearProbing.insert("fox");
        linearProbing.displayHashTable();
        //linearProbing.insert("ever");
    }
}
