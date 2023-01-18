package com.company;

import java.util.ArrayList;

public class QuadraticProbing {
    String[] hash;
    int usedCellNo;
    QuadraticProbing(int size) {
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
        return;
    }
}
