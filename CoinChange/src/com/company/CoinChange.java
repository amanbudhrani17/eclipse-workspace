package com.company;
import java.util.*;

public class CoinChange {
    public static int i = 2;
    public static int f = 0;
    public static void coinChange(int[] coins, int n, int index, int[][] ab){
        String s;
        Arrays.sort(coins);
        while (index>=0){
            int coin = coins[index];
            index--;
            int no = (n/coin)*coin;
            if (no != 0){
//                System.out.println(coin + " - "+n/coin);
                ab[index+1][0] = coin;
                ab[index+1][1] = n/coin;
                n = n-n/coin*coin;
            }
            if (n==0){
                f = 1;
                break;
            }
        }
        if (f==1){
            for (int i = 0; i< ab.length; i++) {
                if (ab[i][0]!=0) {
                    System.out.println(ab[i][0] + " - " + ab[i][1]);
                }
                f = 0;
            }
            return;
        }
        index = coins.length-i++;

        n = n + coins[index+1];
        ab[index+1][1]--;
        coinChange(coins, n, index, ab);

    }
    public static void problem(int[] coins, int n){
        int[][] ab = new int[coins.length][2];
        coinChange(coins,n, coins.length-1,ab );
    }
}
