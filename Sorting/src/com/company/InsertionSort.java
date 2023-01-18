package com.company;

public class InsertionSort {
    void InsertionSort(int[] arr){
        for (int i = 0; i<arr.length; i++){
            int j = i;
            int temp = arr[j];
            while (j>0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
