package com.algo.expert.dynamicprogreamming;

import java.util.List;

public interface SquareOfZeros {

    boolean squareOfZeroes(List<List<Integer>> matrix);

    class Solution1 implements SquareOfZeros {

        @Override
        public boolean squareOfZeroes(List<List<Integer>> matrix) {
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(0).size(); j++) {
                    if (checkSquareAt(matrix, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean checkSquareAt(List<List<Integer>> matrix, int row, int col) {
            if (matrix.get(row).get(col) != 0) {
                return false;
            }
            int size = 1;
            while (true) {
                if (row + size >= matrix.size() || col + size >= matrix.get(0).size()) {
                    return false;
                }
                boolean valid = true;
                for (int i = 0; i <= size && valid; i++) {
                    valid = matrix.get(row).get(col + i) == 0
                            && matrix.get(row + size).get(col + i) == 0
                            && matrix.get(row + i).get(col) == 0
                            && matrix.get(row + i).get(col + size) == 0;
                }
                if (valid) {
                    return true;
                }
                size++;
            }
        }
    }
}
