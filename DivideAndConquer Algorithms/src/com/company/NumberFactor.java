//package com.company;
//
//import java.util.Scanner;
//
//public class NumberFactor {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
////        int[] arr = new int[]{1,3,4};
//        System.out.println(NumberFactor(n));
//        // write your code here
//    }
//    public static int NumberFactor(int n){
//        int a = 0;
//        int prev = 1;
//        int prev2 = 1;
//        int prev3 = 2;
//        int prev4 = 4;
//        for (int i = 5; i<=n; i++){
//            a = prev4 + prev2 + prev;
//            prev4 = a;
//            prev = prev2;
//            prev2 = prev3;
//            prev3 = prev4;
//            prev4 = a;
//
//        }
//        if(n == 0){
//            return 0;
//        }
//        if (n == 1){
//            return prev;
//        }
//        if (n == 2){
//            return prev2;
//        }
//        if (n == 3){
//            return prev3;
//        }
//        if (n == 4){
//            return prev4;
//        }
//        return a ;
//    }
//}
//// In Divide And Conquer just do return (n-1) + (n-3) + (n-4)
//// And give the 0,1,2,3 answer as stop condition
package com.company;

import java.util.*;

public class NumberFactor {
    public static void main(String[] args){
        int n = 5;
        System.out.println(NumberFactor(n));
    }
    public static int NumberFactor(int n){
        if (n == 0){
            return 0;
        }
        else if (n==1 || n==2){
            return 1;
        }
        else if (n == 3){
            return 2;
        }
        else if (n == 4){
            return 4;
        }
        else return NumberFactor(n-1) + NumberFactor(n-3) + NumberFactor(n-4);
    }
}