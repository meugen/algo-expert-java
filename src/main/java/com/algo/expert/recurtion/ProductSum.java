package com.algo.expert.recurtion;

import java.util.List;

public interface ProductSum {

    int productSum(List<Object> array);

    class Solution1 implements ProductSum {

        @Override
        public int productSum(List<Object> array) {
            return calcProductSum(array, 1);
        }

        private int calcProductSum(List<Object> array, int depth) {
            int result = 0;
            for (Object obj : array) {
                if (obj instanceof Integer) {
                    result += (Integer) obj;
                } else if (obj instanceof List) {
                    result += calcProductSum((List<Object>) obj, depth+1);
                }
            }
            return result * depth;
        }
    }
}
