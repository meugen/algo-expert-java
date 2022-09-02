package com.algo.expert.searching;

import java.util.Arrays;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
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
        //Arrays.sort(result);
        return result;
    }
}
