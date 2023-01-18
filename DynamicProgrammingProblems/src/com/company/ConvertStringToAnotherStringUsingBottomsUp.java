package com.company;

import java.util.Scanner;

public class ConvertStringToAnotherStringUsingBottomsUp {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
        String s1 = "catch";
        String s2 = "cat";
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < s1.length() && j < s2.length()){
            if ( s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else {
                result++;
                s1 = replace(s1,i,s2.charAt(j));
                i++;
                j++;
            }
        }
        int z = j;
        if (i == s1.length()){
            for ( ;i<s2.length(); i++){
                s1 = insert(s2.charAt(i) , s1);
                result++;
            }
            System.out.println(result);
        }
        else if (j == s2.length()){
            int x = s1.length();
            for (; j<x;j++){
                s1 = delete(z,s1);
                result++;
            }
            System.out.println(result);
        }
    }
    public static String replace(String s , int a, char b){
        String str = s.substring(0,a);
        String str2 = s.substring(a+1, s.length());
        s = str + b + str2;
        return s;
    }
    public static String delete(int a, String b){
        StringBuilder sb = new StringBuilder(b);
        sb.deleteCharAt(a);
        return sb.toString();

    }
    public static String insert(char a, String b){
        b = b+a;
        return b;
    }
}
