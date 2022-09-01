package com.algo.expert.greedyalgorithms;

import java.util.Arrays;

public class TandemBicycle {

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        int result = 0;
        for (int i = 0; i<redShirtSpeeds.length; i++) {
            result += Math.max(redShirtSpeeds[i], selectBlueShirt(blueShirtSpeeds, fastest, i));
        }
        return result;
    }

    private static int selectBlueShirt(int[] blueShirtSpeeds, boolean fastest, int index) {
        if (fastest) return blueShirtSpeeds[blueShirtSpeeds.length - index - 1];
        return blueShirtSpeeds[index];
    }
}
