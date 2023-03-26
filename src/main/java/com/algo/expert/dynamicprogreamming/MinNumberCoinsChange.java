package com.algo.expert.dynamicprogreamming;

import java.util.Arrays;

public interface MinNumberCoinsChange {

    int minNumberOfCoinsForChange(int n, int[] denoms);

    class Solution1 implements MinNumberCoinsChange {

        @Override
        public int minNumberOfCoinsForChange(int n, int[] denoms) {
            Arrays.sort(denoms);
            return calculate(n, denoms, 0, 0);
        }

        private int calculate(int n, int[] denoms, int coins, int index) {
            if (index >= denoms.length) return -1;
            int count = 0;
            while (count * denoms[index] <= n) {
                int result;
                if (count * denoms[index] == n) {
                    result = coins + count;
                } else {
                    result = calculate(n - count * denoms[index], denoms, coins + count, index + 1);
                }
                if (result >= 0) return result;
                count++;
            }
            return -1;
        }
    }
}
