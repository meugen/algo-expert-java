package com.algo.expert.graphs;

import java.util.Arrays;
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
            int[] copy = Arrays.copyOf(array, array.length);

            int index = 0;
            for (int i = 0; i < copy.length; i++) {
                int newIndex = index + copy[index];
                while (newIndex >= copy.length) newIndex -= copy.length;
                while (newIndex < 0) newIndex += copy.length;
                copy[index] = 0;
                index = newIndex;
            }
            if (index != 0) return false;
            for (int value : copy) {
                if (value != 0) return false;
            }
            return true;
        }
    }
}
