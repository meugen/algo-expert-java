package com.algo.expert.sorting;

public interface InsertionSort {

    int[] insertionSort(int[] array);

    class Solution1 implements InsertionSort {

        @Override
        public int[] insertionSort(int[] array) {
            for (int i=1; i<array.length; i++) {
                int index = i;
                while (index>0 && array[index]<array[index-1]) {
                    int tmp = array[index-1];
                    array[index-1] = array[index];
                    array[index] = tmp;
                    index--;
                }
            }
            return array;
        }
    }
}
