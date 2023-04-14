package com.algo.expert.arrays;

public interface BestSeat {

    int bestSeat(int[] seats);

    class Solution1 implements BestSeat {

        @Override
        public int bestSeat(int[] seats) {
            int bestIndex = -1;
            int bestLength = 0;

            int curIndex = -1;
            int curLength = 0;
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 0 && curIndex < 0) {
                    curIndex = i;
                }
                if (seats[i] == 0) {
                    curLength++;
                } else {
                    curIndex = -1;
                    curLength = 0;
                }
                if (curLength > bestLength) {
                    bestIndex = curIndex;
                    bestLength = curLength;
                }
            }
            if (bestIndex < 0) return -1;
            int result = bestIndex + bestLength / 2;
            if (bestLength % 2 == 0) {
                result--;
            }
            return result;
        }
    }
}
