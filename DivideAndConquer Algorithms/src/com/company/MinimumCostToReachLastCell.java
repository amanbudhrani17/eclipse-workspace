package com.company;

public class MinimumCostToReachLastCell {
    public static void main(String[] args){
        int[][] a = { { 1, 3 }, { 2, 4 },{ 5, 6 }, { 4, 12 }};
        System.out.println(MinimumCost(a,0,0));
    }
    public static int MinimumCost(int[][] a, int indexRow, int indexColumn){
        if (indexRow == a.length-1 && indexColumn!=a[0].length-1){
            int i = a[indexRow][indexColumn] + MinimumCost(a, indexRow, indexColumn + 1);
            return i;
        }
        if (indexColumn == a[0].length-1 && indexRow != a.length-1){
            int i= a[indexRow][indexColumn] + MinimumCost(a, indexRow + 1, indexColumn);
            return i;
        }
        if (indexRow == a.length-1 && indexColumn == a[0].length-1){
            int i= a[indexRow][indexColumn];
            return i;
        }
        else {
            int p1 = a[indexRow][indexColumn]+MinimumCost(a,indexRow+1,indexColumn);
            int p2 = a[indexRow][indexColumn]+MinimumCost(a, indexRow, indexColumn+1);
            return Math.min(p1,p2);
        }
    }
}
