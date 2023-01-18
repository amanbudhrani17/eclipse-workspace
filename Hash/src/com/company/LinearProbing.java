package com.company;

import java.util.ArrayList;

public class LinearProbing {
    String[] hash;
    int usedCellNo;
    LinearProbing(int size) {
        hash = new String[size];
        usedCellNo = 0;
    }
    public int modASCII(String word, int m){
        char ch[];
        ch = word.toCharArray();
        int i , sum = 0;
        for (i = 0; i<ch.length; i++){
            sum += ch[i];
        }
        return sum%m;
    }
    public double getLoadFactor(){
        double load =usedCellNo*1.0/hash.length;
        return load;
    }
    public void rehash(String word){
        usedCellNo = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String s : hash) {
            if (s != null) {
                data.add(s);
            }
        }
        data.add(word);
        hash = new String[hash.length * 2];
        for (String  a : data){
            insert(a);
        }
    }
    public void insert(String word){
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75){
            rehash(word);
        }
        else {
            int index = modASCII(word, hash.length);
                for(int i = index; i<index + hash.length; i++){
                    int newIndex = i%hash.length;
                    if (hash[newIndex] == null){
                        hash[newIndex] = word;
                        //System.out.println(word);
                        break;
                    }
                }
            }
        usedCellNo++;
    }
    public void displayHashTable() {
        if (hash == null) {
            System.out.println("\nHashTable does not exists");
            return;
        } else {
            System.out.println("\n----------HashTable----------");
            for (int i=0; i<hash.length; i++) {
                System.out.println("Index " + i + ", key:" + hash[i]);
            }
        }
    }
}
