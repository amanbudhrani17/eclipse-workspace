package com.company;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int m =LongestCommon(s1,s2,0,0);
        System.out.println(m);

    }
    public static int LongestCommon(String s1, String s2, int index1, int index2){
        if (index1 == s1.length() || index2 == s2.length()){
            return 0;
        }
        int c = 0;
        if (s1.charAt(index1) == s2.charAt(index2)) {
            c =  1 + LongestCommon(s1, s2, index1+1, index2+1);
        }
            int p1 = LongestCommon(s1, s2, index1+1, index2);
            int p2 = LongestCommon(s1, s2, index1, index2+1);
            return Math.max(c,Math.max(p1,p2));
    }
}
