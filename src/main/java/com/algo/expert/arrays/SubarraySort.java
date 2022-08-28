package com.algo.expert.arrays;

public class SubarraySort {

    private final int[] array;

    SubarraySort(int[] array) {
        this.array = array;
    }

    int[] run() {
        int max = Integer.MIN_VALUE;
        int unsortedStart = -1;
        int unsortedEnd = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < max) {
                unsortedEnd = i;
                unsortedStart = unsortedStart == -1
                        ? binarySearch(0, i - 1, array[i])
                        : binarySearch(0, unsortedStart, array[i]);
            } else {
                max = array[i];
            }
        }

        return new int[] {unsortedStart, unsortedEnd};
    }

    private int binarySearch(int start, int end, int value) {
        if (start >= end) return start;
        if (start == end - 1) {
            return value < array[start] ? start : end;
        }
        int middle = (start + end) / 2;
        if (value < array[middle]) return binarySearch(start, middle, value);
        return binarySearch(middle, end, value);
    }

    public static int[] subarraySort(int[] array) {
        return new SubarraySort(array).run();
    }
}
