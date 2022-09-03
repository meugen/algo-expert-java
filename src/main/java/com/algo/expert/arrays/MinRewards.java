package com.algo.expert.arrays;

public interface MinRewards {

    int minRewards(int[] scores);

    class Solution1 implements MinRewards {

        @Override
        public int minRewards(int[] scores) {
            int[] rewards = new int[scores.length]; // items will be filled as 0

            int start = 0;
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] < scores[i - 1]) {
                    for (int j = i; j > start; j--) {
                        rewards[j - 1] = Math.max(rewards[j - 1], rewards[j] + 1);
                    }
                } else {
                    rewards[i] = rewards[i - 1] + 1;
                    start = i;
                }
            }

            int result = 0;
            for (int reward : rewards) result += reward;
            return result + scores.length; // every student should have a reward
        }
    }
}
