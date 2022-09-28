package com.algo.expert.arrays;

import java.util.Arrays;

public interface SortedSquaredArray {

    int[] sortedSquaredArray(int[] array);

    class Solution1 implements SortedSquaredArray {

        @Override
        public int[] sortedSquaredArray(int[] array) {
            int[] result = new int[array.length];
            for (int i=0; i<array.length; i++) {
                result[i] = array[i] * array[i];
            }
            Arrays.sort(result);
            return result;
        }
    }
}
