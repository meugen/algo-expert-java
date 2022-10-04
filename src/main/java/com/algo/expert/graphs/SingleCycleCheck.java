package com.algo.expert.graphs;

import java.util.HashSet;
import java.util.Set;

public interface SingleCycleCheck {

    boolean hasSingleCycle(int[] array);

    class Solution1 implements SingleCycleCheck {

        @Override
        public boolean hasSingleCycle(int[] array) {
            int index = 0;
            Set<Integer> visited = new HashSet<>();
            while (true) {
                if (visited.contains(index)) {
                    return index == 0 && visited.size() == array.length;
                }
                visited.add(index);
                index += array[index];
                while (index >= array.length) index -= array.length;
                while (index < 0) index += array.length;
            }
        }
    }

    class Solution2 implements SingleCycleCheck {

        @Override
        public boolean hasSingleCycle(int[] array) {
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                int newIndex = index + array[index];
                while (newIndex >= array.length) newIndex -= array.length;
                while (newIndex < 0) newIndex += array.length;
                array[index] = 0;
                index = newIndex;
            }
            if (index != 0) return false;
            for (int value : array) {
                if (value != 0) return false;
            }
            return true;
        }
    }
}
