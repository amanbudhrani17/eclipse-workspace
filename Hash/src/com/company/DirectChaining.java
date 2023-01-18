package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hash;    // init
    int maxChainSize = 5;
    DirectChaining(int size){
        hash = new LinkedList[size];      // point + box
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
    public void insert(String word){
        int index = modASCII(word, hash.length);
        if (hash[index] == null){
            hash[index] = new LinkedList<String>();
            hash[index].add(word);
        }
        else {
            hash[index].add(word);
        }
    }
    public void search(String word){
        int index = modASCII(word,hash.length);
            if(hash[index] != null && hash[index].contains(word)){
                System.out.println("Found");
            }
            else System.out.println("Not Found");
    }
    public void delete(String word){
        int index = modASCII(word, hash.length);
        if(hash[index] != null && hash[index].contains(word)){
            hash[index].remove(word);
            System.out.println("Deleted");
        }
        else System.out.println("Not Found");
    }
    public void display(){
        for (int i = 0; i<hash.length; i++){
            System.out.println(i + " " + hash[i]);
        }
    }

}
