package com.algo.expert.dynamicprogreamming;

public interface NumberWaysMakeChange {

    int numberOfWaysToMakeChange(int n, int[] denoms);

    class Solution1 implements NumberWaysMakeChange {

        @Override
        public int numberOfWaysToMakeChange(int n, int[] denoms) {
            return calculate(n, denoms, 0);
        }

        private int calculate(int n, int[] denoms, int index) {
            if (index >= denoms.length) return 0;
            int result = 0;
            int count = 0;
            while (count * denoms[index] <= n) {
                if (count * denoms[index] == n) {
                    result++;
                } else {
                    result += calculate(n - count * denoms[index], denoms, index + 1);
                }
                count++;
            }
            return result;
        }
    }
}
