package com.algo.expert.arrays;

import java.util.Arrays;

public interface MissingNumbers {

    int[] missingNumbers(int[] nums);

    class Solution1 implements MissingNumbers {

        @Override
        public int[] missingNumbers(int[] nums) {
            Arrays.sort(nums);

            var result = new int[2];
            int numsIndex = 0;
            int resultIndex = 0;
            for (int num = 1; num <= nums.length + 2; num++) {
                if (numsIndex < nums.length && nums[numsIndex] == num) {
                    numsIndex++;
                } else if (resultIndex < 2) {
                    result[resultIndex] = num;
                    resultIndex++;
                }
            }
            return result;
        }
    }
}
