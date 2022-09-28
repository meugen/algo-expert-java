package com.algo.expert.arrays;

public interface MonotonicArray {

    boolean isMonotonic(int[] array);

    class Solution1 implements MonotonicArray {

        @Override
        public boolean isMonotonic(int[] array) {
            int order = 0;
            for (int i=1; i<array.length; i++) {
                if (order == 0) {
                    order = calcOrder(array[i], array[i-1]);
                }
                int newOrder = calcOrder(array[i], array[i-1]);
                if (order != 0 && newOrder != 0 && newOrder != order) return false;
            }
            return true;
        }

        private int calcOrder(int val1, int val2) {
            return Integer.compare(val1, val2);
        }
    }
}
