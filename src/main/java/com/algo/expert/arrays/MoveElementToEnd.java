package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// https://www.algoexpert.io/questions/move-element-to-end
public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        List<Integer> result = new ArrayList<>(array);
        int left = 0;
        int right = result.size() - 1;
        while (left<right) {
            if (Objects.equals(result.get(right), toMove)) {
                right--;
            } else {
                Integer tmp = result.get(right);
                result.set(right, result.get(left));
                result.set(left, tmp);
                left++;
            }
        }
        return result;
    }
}
