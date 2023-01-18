package com.company;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Solution {
//    public static long mostPoints(int[][] questions) {
//        long output = 0;
//        int[] arr = new int[questions.length];
//        Comparator<int[]> comparator = new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1]>o2[1]){
//                    return 1;
//                }
//                else return 0;
//            }
//        };
//        Arrays.sort(questions,comparator);
//        for (int i = 0;i< arr.length;i++){
//            arr[i]=questions[i][0];
//        }
//        output = houseRobber(arr,0);
//        return output;
//    }
//    public static int houseRobber(int[] house, int n){
//        if (n>=house.length){
//            return 0;
//        }
//        else {
//            int o1 = house[n] + houseRobber(house, n+3);
//            int o2 = houseRobber(house, n+1);
//            return Math.max(o1,o2);
//        }
//    }
//}
class Solution {
    public static long mostPoints(int[][] questions) {
        long output = 0;
        int[] arr = new int[questions.length];
        for (int i = 0; i<questions.length; i++){
            arr[i] = -1;
        }
        output = houseRobber(questions,0,arr);
        return output;
    }
    public static int houseRobber(int[][] house, int n,int[] arr){

        if (n>=house.length){
            return 0;
        }
        else if (arr[n]!=-1){
            return arr[n];
        }
        else {
            int o1 = house[n][0] + houseRobber(house, n+1+house[n][1],arr);
            int o2 = houseRobber(house, n+1,arr);
            arr[n]=Math.max(o1,o2);
            return Math.max(o1,o2);
        }
    }
}