package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);

        List<Integer[]> result = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                int left=j+1;
                int right=array.length-1;
                while (left<right) {
                    int currentSum = array[i]+array[j]+array[left]+array[right];
                    if (currentSum == targetSum) {
                        result.add(new Integer[] { array[i], array[j], array[left], array[right] });
                        left++;
                        right--;
                    } else if (currentSum<targetSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
