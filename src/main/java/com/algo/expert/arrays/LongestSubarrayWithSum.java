package com.algo.expert.arrays;

import java.util.Comparator;
import java.util.TreeMap;

public interface LongestSubarrayWithSum {
    
    int[] longestSubarrayWithSum(int[] array, int targetSum);

    class Solution1 implements LongestSubarrayWithSum {

        @Override
        public int[] longestSubarrayWithSum(int[] array, int targetSum) {
            var start = 0;
            var end = 0;
            var currentSum = 0;

            var subarrays = new TreeMap<Integer, int[]>(Comparator.reverseOrder());
            while (end < array.length) {
                currentSum += array[end];
                if (currentSum == targetSum) {
                    subarrays.put(end - start + 1, new int[] {start, end});
                } else if (currentSum > targetSum) {
                    currentSum -= array[start];
                    start++;
                }
                end++;
            }
            return subarrays.isEmpty() ? new int[] {} : subarrays.entrySet().iterator().next().getValue();
        }
    }
}
