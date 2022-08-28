package com.algo.expert.arrays;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        int result = 0;
        if (array.length<3) return result;

        int lastDown = -1;
        for (int i=0; i<array.length; i++) {
            if (i == 0 && array[0] < array[1]) {
                lastDown = 0;
            } else if (i>0 && array[i] == array[i-1]) {
                lastDown = i<array.length-1 && array[i]<array[i+1]
                        ? i : -1;
            } else if (i>0 && array[i] < array[i-1]) {
                if (lastDown>=0)
                    result = Math.max(result, i-lastDown+1);
                if (i<array.length-1 && array[i]<array[i+1])
                    lastDown = i;
            }
        }
        return result;
    }
}
