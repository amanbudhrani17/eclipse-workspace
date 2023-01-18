package com.company;

public class MinimumCostToReachLastCellWithGivenCost {
    public static void main(String[] args){
        int[][] a = { { 1, 3 }, { 2, 4 }, { 5, 6 }};
        System.out.println(MinimumCost(a,0,0,14));
    }
    public static int MinimumCost(int[][] a, int indexRow, int indexColumn , int cost){
        if (cost<0){
            return 0;
        }
        else if (indexRow == a.length-1 && indexColumn == a[0].length-1){
            if (cost - a[indexRow][indexColumn] == 0) return 1;
            else return 0;
        }
        else if (indexRow == a.length-1){
            return MinimumCost(a,indexRow,indexColumn+1,cost-a[indexRow][indexColumn]);
        }
        else if (indexColumn == a[0].length-1){
            return MinimumCost(a, indexRow+1, indexColumn, cost-a[indexRow][indexColumn]);
        }
        else {
            int p1 = MinimumCost(a,indexRow+1,indexColumn,cost-a[indexRow][indexColumn]);
            int p2 = MinimumCost(a,indexRow,indexColumn+1,cost-a[indexRow][indexColumn]);
            return p1+p2;
        }
    }
}
