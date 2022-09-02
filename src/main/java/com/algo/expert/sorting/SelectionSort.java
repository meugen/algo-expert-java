package com.algo.expert.sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        // Write your code here.
        for (int i = 0; i<array.length; i++) {
            int smallestIdx = i;
            for (int j = i; j<array.length; j++) {
                if (array[j] < array[smallestIdx]) {
                    smallestIdx = j;
                }
            }
            int tmp = array[i];
            array[i] = array[smallestIdx];
            array[smallestIdx] = tmp;
        }
        return array;
    }
}
