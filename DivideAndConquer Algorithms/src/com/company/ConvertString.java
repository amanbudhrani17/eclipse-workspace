
//MyMethod




//package com.company;
//
//import java.util.Scanner;
//
//public class ConvertString {
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String s1 = "cmsksk";
//        String s2 = "cnjkcsd";
//        int i = 0;
//        int j = 0;
//        int result = 0;
//        while (i < s1.length() && j < s2.length()){
//            if ( s1.charAt(i) == s2.charAt(j)){
//                i++;
//                j++;
//            }
//            else {
//                result++;
//                s1 = replace(s1,i,s2.charAt(j));
//                i++;
//                j++;
//            }
//        }
//        int z = j;
//        if (i == s1.length()){
//            for ( ;i<s2.length(); i++){
//                s1 = insert(s2.charAt(i) , s1);
//                result++;
//            }
//            System.out.println(result);
//        }
//        else if (j == s2.length()){
//            int x = s1.length();
//            for (; j<x;j++){
//                s1 = delete(z,s1);
//                result++;
//            }
//            System.out.println(result);
//        }
//    }
//    public static String replace(String s , int a, char b){
//        String str = s.substring(0,a);
//        String str2 = s.substring(a+1, s.length());
//        s = str + b + str2;
//        return s;
//    }
//    public static String delete(int a, String b){
//        StringBuilder sb = new StringBuilder(b);
//        sb.deleteCharAt(a);
//        return sb.toString();
//
//    }
//    public static String insert(char a, String b){
//        b = b+a;
//        return b;
//    }
//}






//DivideAndConquerMethod





package com.company;
public class ConvertString {
    public static void main(String[] args){
        String s1 = "carch";
        String s2 = "cat";
        System.out.println(min(s1,s2,0,0));
    }
    public static int min(String s1, String s2, int index1, int index2){
        if (s1.length() == index1){
            return s2.length()-index2;
        }
        if (s2.length() == index2){
            return s1.length() - index1;
        }
        if (s1.charAt(index1) == s2.charAt(index2)){
            return min(s1, s2, index1+1, index2+1);
        }
        else {
            int delete = 1 + min(s1,s2,index1,index2+1);
            int insert = 1 + min(s1,s2,index1+1,index2);
            int replace = 1 + min(s1, s2, index1+1, index2+1);
            int m = Math.min(delete,insert);
            return Math.min(replace,m);
        }
    }
}
