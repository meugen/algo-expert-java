package com.algo.expert.famousalgorithms;

public interface KadanesAlgorithm {

    int kadanesAlgorithm(int[] array);

    class Solution1 implements KadanesAlgorithm {

        @Override
        public int kadanesAlgorithm(int[] array) {
            int result = 0;
            int partialSum = 0;
            for (int value : array) {
                if (value < 0) {
                    result += Math.max(partialSum, 0);
                    partialSum = 0;
                }
                partialSum += value;
            }
            result += Math.max(partialSum, 0);
            return result;
        }
    }
}
