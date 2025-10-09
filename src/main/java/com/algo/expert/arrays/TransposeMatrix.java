package com.algo.expert.arrays;

public interface TransposeMatrix {
    
    int[][] transposeMatrix(int[][] matrix);

    class Slution1 implements TransposeMatrix {

        @Override
        public int[][] transposeMatrix(int[][] matrix) {
            int h = matrix.length;
            int w = matrix[0].length;

            int[][] result = new int[w][];
            for (int i = 0; i < w; i++) {
                result[i] = new int[h];
                for (int j = 0; j < h; j++) {
                    result[i][j] = matrix[j][i];
                }
            }
            return result;
        }
    }
}
