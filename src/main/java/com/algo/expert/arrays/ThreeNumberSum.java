package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.algoexpert.io/questions/three-number-sum
public class ThreeNumberSum {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < array.length-2; i++) {
            for (int j = i+1; j < array.length-1; j++) {
                int index = binarySearch(array, targetSum-array[i]-array[j], j+1, array.length-1);
                if (index >= 0) {
                    result.add(new Integer[] { array[i], array[j], array[index] });
                }
            }
        }
        return result;
    }

    private static int binarySearch(int[] array, int target, int start, int end) {
        if (array[start]==target) return start;
        if (array[end]==target) return end;
        if (end-start <= 1) return -1;
        int middle = (start + end) / 2;
        if (array[middle]>target) return binarySearch(array, target, start, middle);
        return binarySearch(array, target, middle, end);
    }
}
