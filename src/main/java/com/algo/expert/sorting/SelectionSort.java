package com.algo.expert.sorting;

public interface SelectionSort {

    int[] selectionSort(int[] array);

    class Solution1 implements SelectionSort {

        @Override
        public int[] selectionSort(int[] array) {
            for (int i = 0; i<array.length; i++) {
                int smallestIdx = i;
                for (int j = i; j<array.length; j++) {
                    if (array[j] < array[smallestIdx]) {
                        smallestIdx = j;
                    }
                }
                int tmp = array[i];
                array[i] = array[smallestIdx];
                array[smallestIdx] = tmp;
            }
            return array;
        }
    }
}
