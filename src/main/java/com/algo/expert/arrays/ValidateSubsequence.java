package com.algo.expert.arrays;

import java.util.List;
import java.util.Objects;

public class ValidateSubsequence {

    private ValidateSubsequence() {}

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int index = -1;
        for (int i=0; i<array.size() && index<sequence.size()-1; i++) {
            if (Objects.equals(array.get(i), sequence.get(index+1))) {
                index++;
            }
        }
        return index == sequence.size()-1;
    }
}
