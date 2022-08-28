package com.algo.expert.arrays;

public class ArrayOfProducts {

    public static int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        for (int i=0; i<array.length; i++) {
            result[i] = 1;
            for (int j=0; j<array.length; j++) {
                if (i != j) result[i] *= array[j];
            }
        }
        return result;
    }
}
