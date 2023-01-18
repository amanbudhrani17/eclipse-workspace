package com.company;


import java.security.PublicKey;

public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode current = root;
        for (int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.print(word + " ");
    }
    public boolean search(String word){
        TrieNode current = root;
        for (int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null){
                System.out.println("Word Not Found");
                return false;
            }
            current = node;
        }
        if (current.endOfString == false){
            System.out.println("Word Prefix Found");
            return  false;
        }
        else {
            System.out.println("Word Found");
            return true;
        }
    }
    private boolean deleteTrie(TrieNode parent, String word, int index){
        char ch = word.charAt(index);
        TrieNode currentNode = parent.children.get(ch);
        boolean canThis;
        if (currentNode.children.size() > 1){
            deleteTrie(currentNode, word, index+1);
            return false;
        }
        if (index == word.length()-1){
            if (currentNode.children.size() >= 1){
                currentNode.endOfString = false;
                return false;
            }
            else {
                parent.children.remove(ch);
                return true;
            }
        }
        if(currentNode.endOfString == true){
            deleteTrie(currentNode, word, index+1);
            return false;
        }
        canThis =  deleteTrie(currentNode, word, index+1);
        if (canThis == true){
            currentNode.children.remove(ch);
            return true;
        }
        else {
            return false;
        }
    }
    public void delete(String word){
            deleteTrie(root,word,0);
    }
}
