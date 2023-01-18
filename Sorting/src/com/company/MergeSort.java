package com.company;

public class MergeSort {
    public static void mergeSort(int[] A, int left, int right){
        if (left<right) {
            int m = (left+right)/2;
            mergeSort(A, left ,m);
            mergeSort(A, m+1 , right);
            merge(A, left, m , right);
        }
    }
    static void merge(int[] A, int left, int middle, int right){
        int[] leftTemp = new int[middle - left + 2];
        int[] rightTemp = new int[right - middle +1];
        for (int i = 0; i<=middle-left; i++){
            leftTemp[i] = A[left+i];
        }
        for (int j = 0; j<right-middle; j++){
            rightTemp[j] = A[middle+1+j];
        }
        leftTemp[middle-left+1] = Integer.MAX_VALUE;
        rightTemp[right-middle] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = left; k<=right; k++){
            if(leftTemp[i]<rightTemp[j]){
                A[k] = leftTemp[i];
                i++;
            }
            else{
                A[k] = rightTemp[j];
                j++;
            }
        }
    }
}
