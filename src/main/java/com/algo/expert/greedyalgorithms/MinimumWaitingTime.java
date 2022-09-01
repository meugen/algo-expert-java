package com.algo.expert.greedyalgorithms;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static int minimumWaitingTime(int[] queries) {
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
