package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{ 5,4,9,2,3 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.BubbleSort(arr);
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr,0,arr.length-1);
	    //MergeSort mergeSort = new MergeSort();
        //mergeSort.mergeSort(arr, 0, arr.length-1);
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
/*

 */