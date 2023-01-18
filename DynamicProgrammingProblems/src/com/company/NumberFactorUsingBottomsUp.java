package com.company;

import java.util.Scanner;

public class NumberFactorUsingBottomsUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] arr = new int[]{1,3,4};
        System.out.println(NumberFactor(n));
        // write your code here
    }
    public static int NumberFactor(int n){
        int a = 0;
        int prev = 1;
        int prev2 = 1;
        int prev3 = 2;
        int prev4 = 4;

        if (n == 1){
            return prev;
        }
        if (n == 2){
            return prev2;
        }
        if (n == 3){
            return prev3;
        }
        if (n == 4){
            return prev4;
        }
        for (int i = 5; i<=n; i++){
            a = prev4 + prev2 + prev;
            prev = prev2;
            prev2 = prev3;
            prev3 = prev4;
            prev4 = a;
        }
        return a;
    }
}