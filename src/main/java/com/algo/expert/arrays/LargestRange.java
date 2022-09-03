package com.algo.expert.arrays;

import java.util.Arrays;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        // Write your code here.
        Arrays.sort(array);

        int[] result = null;
        int start = array[0];
        int end = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1] + 1) {
                if (result == null || end - start >= result[1] - result[0]) {
                    result = new int[] {start, end};
                }
                start = array[i];
            }
            end = array[i];
        }
        if (result == null || end - start >= result[1] - result[0]) {
            result = new int[] {start, end};
        }
        return result;
    }
}
