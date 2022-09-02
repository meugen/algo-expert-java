package com.algo.expert.searching;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        return internalBinarySearch(array, target, 0, array.length-1);
    }

    private static int internalBinarySearch(int[] array, int target, int startIndex, int endIndex) {
        if (array[startIndex] == target) return startIndex;
        if (array[endIndex] == target) return endIndex;
        if (endIndex-startIndex <= 1) return -1;
        int middleIndex = (startIndex + endIndex) / 2;
        if (target < array[middleIndex]) return internalBinarySearch(array, target, startIndex, middleIndex);
        return internalBinarySearch(array, target, middleIndex, endIndex);
    }
}
