package com.algo.expert.arrays;

import java.util.HashSet;

public interface ZeroSumSubarray {

    boolean zeroSumSubarray(int[] nums);

    class Solution1 implements ZeroSumSubarray {

        @Override
        public boolean zeroSumSubarray(int[] nums) {
            if (nums.length == 0) return false;

            var set = new HashSet<Integer>();
            set.add(0);

            var sum = 0;
            for (int num : nums) {
                sum += num;
                if (set.contains(sum)) return true;
                set.add(sum);
            }
            return false;
        }
    }
}
