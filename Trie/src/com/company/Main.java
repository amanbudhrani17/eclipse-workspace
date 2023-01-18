package com.company;

public class Main {

    public static void main(String[] args) {
	    Trie newTrie = new Trie();
        //newTrie.insert("APIS");
        newTrie.insert("API");
        //newTrie.search("Fuck");
        newTrie.search("API");
        newTrie.delete("API");
        newTrie.search("API");
    }
}
