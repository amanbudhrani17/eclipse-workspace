package com.company;
public class ConvertStringToAnotherStringUsingTopDown {
    public static void main(String[] args){
        String s1 = "table";
        String s2 = "tbres";
        int arr[][] = new int[s1.length()+1][s2.length()+1];
        System.out.println(min(s1,s2,0,0 ,arr));
    }
    public static int min(String s1, String s2, int index1, int index2, int[][] arr){
        if (s1.length() == index1){
            arr[index1][index2] = s2.length()-index2;
            return s2.length()-index2;
        }
        if (s2.length() == index2){
            arr[index1][index2] = s1.length()-index1;
            return s1.length() - index1;
        }
        if (s1.charAt(index1) == s2.charAt(index2)){
            arr[index1][index2] = min(s1, s2, index1+1, index2+1,arr);
            return min(s1, s2, index1+1, index2+1,arr);
        }
        else {
            if (arr[index1][index2] == 0) {
                int delete = 1 + min(s1, s2, index1, index2 + 1, arr);
                int insert = 1 + min(s1, s2, index1 + 1, index2, arr);
                int replace = 1 + min(s1, s2, index1 + 1, index2 + 1, arr);
                int m = Math.min(delete, insert);
                arr[index1][index2] = Math.min(replace,m);
            }
            return arr[index1][index2];
        }
    }
}
