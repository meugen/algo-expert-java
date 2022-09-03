package com.algo.expert.arrays;

import java.util.ArrayList;
import java.util.List;

public interface ZigzagTraverse {

    List<Integer> zigzagTraverse(List<List<Integer>> array);

    class Solution1 implements ZigzagTraverse {

        @Override
        public List<Integer> zigzagTraverse(List<List<Integer>> array) {
            // Write your code here.
            if (array.isEmpty() || array.get(0).isEmpty()) return List.of();

            List<Integer> result = new ArrayList<>();
            result.add(array.get(0).get(0));

            int x = 0;
            int y = 0;
            int dx = -1;
            int dy = 1;
            while (x != array.get(0).size() - 1 || y != array.size() - 1) {
                int newX = Math.max(x + dx, 0);
                int newY = Math.max(y + dy, 0);
                if (x == newX || y == newY) {
                    dx *= -1;
                    dy *= -1;
                }
                x = newX;
                y = newY;
                if (x < array.get(0).size() && y < array.size()) {
                    result.add(array.get(y).get(x));
                }
            }
            return result;
        }
    }
}
