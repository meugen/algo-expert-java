package com.algo.expert.recurtion;

import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        // Write your code here.
        return calcProductSum(array, 1);
    }

    private static int calcProductSum(List<Object> array, int depth) {
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
