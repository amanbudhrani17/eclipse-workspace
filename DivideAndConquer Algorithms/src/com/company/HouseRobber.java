package com.company;

public class HouseRobber {
    public static void main(String[] args){
        int[] a = new int[]{6,7,1,30,8,2,4};
        System.out.println(houseRobber(a,0));
    }
    public static int houseRobber(int[] house, int n){
        if (n>=house.length){
            return 0;
        }
        else {
            int o1 = house[n] + houseRobber(house, n+2);
            int o2 = houseRobber(house, n+1);
            return Math.max(o1,o2);
        }
    }
}
