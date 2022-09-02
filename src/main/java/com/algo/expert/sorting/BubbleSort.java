package com.algo.expert.sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        boolean needRepeat = true;
        while (needRepeat) {
            needRepeat = false;
            for (int i=0; i<array.length-1; i++) {
                if (array[i]>array[i+1]) {
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    needRepeat = true;
                }
            }
        }
        return array;
    }
}
