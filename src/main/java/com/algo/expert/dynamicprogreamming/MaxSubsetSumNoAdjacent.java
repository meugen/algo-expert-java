package com.algo.expert.dynamicprogreamming;

import java.util.Arrays;

public interface MaxSubsetSumNoAdjacent {

    int maxSubsetSumNoAdjacent(int[] array);

    class Solution1 implements MaxSubsetSumNoAdjacent {
        private int[] memo;

        @Override
        public int maxSubsetSumNoAdjacent(int[] array) {
            memo = new int[array.length];
            Arrays.fill(memo, -1);
            return calculateFrom(array, 0);
        }

        private int calculateFrom(int[] array, int index) {
            if (index >= array.length) return 0;
            if (memo[index] >= 0) return memo[index];
            int result = 0;
            result = Math.max(calculateFrom(array, index + 1), result);
            result = Math.max(calculateFrom(array, index + 2) + array[index], result);
            return result;
        }
    }
}
