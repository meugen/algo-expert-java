package com.algo.expert.arrays;

import java.util.Arrays;

public class TwoNumberSum {

    private TwoNumberSum() {}

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        for (int i=0; i<array.length; i++) {
            int first = array[i];
            int second = targetSum - first;
            int index = binarySearch(array, i+1, array.length-1, second);
            if (index >= 0) {
                return new int[] {first, second};
            }
        }
        return new int[0];
    }

    private static int binarySearch(int[] array, int start, int end, int value) {
        if (start >= array.length) return -1;
        if (array[start] == value) return start;
        end = Math.min(array.length-1, end);
        if (array[end] == value) return end;
        if (end-start <= 1) return -1;
        int index = (start+end)/2;
        if (array[index] == value) return index;
        if (array[index] > value) return binarySearch(array, start, index-1, value);
        return binarySearch(array, index+1, end, value);
    }
}
