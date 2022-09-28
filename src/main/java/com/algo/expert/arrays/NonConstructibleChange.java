package com.algo.expert.arrays;

import java.util.Arrays;

// https://www.algoexpert.io/questions/non-constructible-change
public interface NonConstructibleChange {

    int nonConstructibleChange(int[] coins);

    class Solution1 implements NonConstructibleChange {

        @Override
        public int nonConstructibleChange(int[] coins) {
            Arrays.sort(coins);
            int change = 0;
            for (int coin : coins) {
                if (coin > change+1) {
                    return change+1;
                } else {
                    change += coin;
                }
            }
            return change+1;
        }
    }
}
