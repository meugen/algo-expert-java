package com.algo.expert.arrays;

import java.util.HashSet;
import java.util.Set;

public interface FirstDuplicateValue {

    int firstDuplicateValue(int[] array);

    class Solution1 implements FirstDuplicateValue {

        @Override
        public int firstDuplicateValue(int[] array) {
            Set<Integer> set = new HashSet<>();
            for (int value : array) {
                if (set.contains(value)) {
                    return value;
                }
                set.add(value);
            }
            return -1;
        }
    }
}
