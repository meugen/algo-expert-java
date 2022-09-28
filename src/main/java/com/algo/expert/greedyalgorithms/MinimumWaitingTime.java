package com.algo.expert.greedyalgorithms;

import java.util.Arrays;

public interface MinimumWaitingTime {

    int minimumWaitingTime(int[] queries);

    class Solution1 implements MinimumWaitingTime {

        @Override
        public int minimumWaitingTime(int[] queries) {
            Arrays.sort(queries);
            int totalWaiting = 0;
            int queryWaiting = 0;
            for (int query : queries) {
                totalWaiting += queryWaiting;
                queryWaiting += query;
            }
            return totalWaiting;
        }
    }
}
