package com.algo.expert.famousalgorithms;

public interface KadanesAlgorithm {

    int kadanesAlgorithm(int[] array);

    class Solution1 implements KadanesAlgorithm {

        @Override
        public int kadanesAlgorithm(int[] array) {
            int result = Integer.MIN_VALUE;
            int sum = 0;
            for (int value : array) {
                sum = Math.max(value, sum + value);
                result = Math.max(result, sum);
            }
            return result;
        }
    }
}
