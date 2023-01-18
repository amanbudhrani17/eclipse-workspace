package com.company;

import java.util.Scanner;

public class LongestPalindromicSubsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println(LongestPalindromeProblem(s1));
    }
    public static int LongestPalindrome(String s1, int start, int end){
        if (start==end){
            return 1;
        }
        if (start>end){
            return 0;
        }
        if (s1.charAt(start) == s1.charAt(end)){
            return 2 + LongestPalindrome(s1, start+1, end-1);
        }
        else {
            int p1 = LongestPalindrome(s1,start+1,end);
            int p2 = LongestPalindrome(s1,start,end-1);
            return Math.max(p1,p2);
        }
    }
    public static int LongestPalindromeProblem(String s1){
        if (LongestPalindrome(s1,0,s1.length()-1)>1){
            return LongestPalindrome(s1,0,s1.length()-1);
        }
        else return 0;
    }
}
