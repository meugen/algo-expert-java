package com.algo.expert.arrays;

import java.util.List;
import java.util.Map;

public interface ApartmentHunting {

    int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs);

    class Solution1 implements ApartmentHunting {

        @Override
        public int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
            // Write your code here.
            int[][] distances = new int[reqs.length][];
            for (int i = 0; i < distances.length; i++) {
                distances[i] = new int[blocks.size() + 1];
                distances[i][0] = -1;
            }

            for (int i = 0; i < blocks.size(); i++) {
                Map<String, Boolean> block = blocks.get(i);
                for (int j = 0; j < reqs.length; j++) {
                    if (block.getOrDefault(reqs[j], false)) {
                        distances[j][0] = i;
                        updateDistances(distances, i, j);
                    }
                    distances[j][i + 1] = distances[j][0] < 0 ? Integer.MAX_VALUE : i - distances[j][0];
                }
            }

            int minIndex = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < blocks.size(); i++) {
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < reqs.length; j++) {
                    max = Math.max(distances[j][i + 1], max);
                }
                if (max < minDistance) {
                    minDistance = max;
                    minIndex = i;
                }
            }
            return minIndex;
        }

        private void updateDistances(int[][] distances, int end, int index) {
            for (int i = 0; i < end; i++) {
                distances[index][i + 1] = Math.min(distances[index][i + 1], Math.abs(i - distances[index][0]));
            }
        }
    }
}
