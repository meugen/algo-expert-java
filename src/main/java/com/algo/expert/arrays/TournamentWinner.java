package com.algo.expert.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TournamentWinner {

    String tournamentWinner(List<List<String>> competitions, List<Integer> results);

    class Solution1 implements  TournamentWinner {

        @Override
        public String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
            String winner = null;
            int score = 0;

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < results.size(); i++) {
                String winTeam;
                if (results.get(i) > 0) {
                    winTeam = competitions.get(i).get(0);
                } else {
                    winTeam = competitions.get(i).get(1);
                }
                Integer winScore = map.get(winTeam);
                if (winScore == null) {
                    winScore = 0;
                }
                winScore += 3;
                map.put(winTeam, winScore);
                if (winScore > score) {
                    winner = winTeam;
                    score = winScore;
                }
            }
            return winner;
        }
    }
}
