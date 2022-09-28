package com.algo.expert.arrays;

import java.util.Arrays;

// https://www.algoexpert.io/questions/smallest-difference
public interface SmallestDifference {

    int[] smallestDifference(int[] arrayOne, int[] arrayTwo);

    class Solution1 implements SmallestDifference {

        @Override
        public int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
            Arrays.sort(arrayTwo);

            int[] result = new int[] { arrayOne[0], findItemWithSmallestDifference(arrayTwo, arrayOne[0]) };
            for (int i=1; i<arrayOne.length; i++) {
                int itemOne = arrayOne[i];
                int itemTwo = findItemWithSmallestDifference(arrayTwo, itemOne);
                if (Math.abs(result[0]-result[1]) > Math.abs(itemOne-itemTwo)) {
                    result[0] = itemOne;
                    result[1] = itemTwo;
                }
            }
            return result;
        }

        private int findItemWithSmallestDifference(int[] array, int target) {
            int index = 0;
            int difference = Math.abs(target-array[0]);
            while (index < array.length-1) {
                int newDifference = Math.abs(target-array[index+1]);
                if (newDifference > difference) {
                    break;
                }
                index++;
                difference = newDifference;
            }
            return array[index];
        }
    }
}
