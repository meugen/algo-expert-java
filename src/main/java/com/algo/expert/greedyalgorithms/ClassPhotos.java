package com.algo.expert.greedyalgorithms;

import java.util.Collections;
import java.util.List;

public interface ClassPhotos {

    boolean classPhotos(List<Integer> redShirtHeights, List<Integer> blueShirtHeights);

    class Solution1 implements ClassPhotos {

        @Override
        public boolean classPhotos(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
            Collections.sort(redShirtHeights);
            Collections.sort(blueShirtHeights);
            int firstSign = sign(redShirtHeights.get(0)-blueShirtHeights.get(0));
            if (firstSign==0) return false;
            for (int i=1; i<redShirtHeights.size(); i++) {
                if (sign(redShirtHeights.get(i)-blueShirtHeights.get(i)) != firstSign) return false;
            }
            return true;
        }

        private int sign(int value) {
            return Integer.compare(value, 0);
        }
    }
}
