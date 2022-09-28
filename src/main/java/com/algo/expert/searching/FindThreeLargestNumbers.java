package com.algo.expert.searching;

import java.util.Arrays;

public interface FindThreeLargestNumbers {

    int[] findThreeLargestNumbers(int[] array);

    class Solution1 implements FindThreeLargestNumbers {

        @Override
        public int[] findThreeLargestNumbers(int[] array) {
            int [] result = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
            for (int value : array) {
                for (int i=0; i<result.length; i++) {
                    if (value > result[i]) {
                        result[i] = value;
                        Arrays.sort(result);
                        break;
                    }
                }
            }
            return result;
        }
    }
}
