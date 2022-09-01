package com.algo.expert.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class Photos {

    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int firstSign = sign(redShirtHeights.get(0)-blueShirtHeights.get(0));
        if (firstSign==0) return false;
        for (int i=1; i<redShirtHeights.size(); i++) {
            if (sign(redShirtHeights.get(i)-blueShirtHeights.get(i)) != firstSign) return false;
        }
        return true;
    }

    private static int sign(int value) {
        return Integer.compare(value, 0);
    }
}
