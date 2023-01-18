package com.company;

public class SelectionSort {
    void SelectionSort(int[] arr){
        int min = 0;
        for (int i =0; i<arr.length; i++){
            for (int j = 0; j< arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
