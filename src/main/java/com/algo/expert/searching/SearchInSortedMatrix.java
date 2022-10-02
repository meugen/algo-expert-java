package com.algo.expert.searching;

public interface SearchInSortedMatrix {

    int[] searchInSortedMatrix(int[][] matrix, int target);

    class Solution1 implements SearchInSortedMatrix {

        @Override
        public int[] searchInSortedMatrix(int[][] matrix, int target) {
            int top = 0;
            int left = 0;
            int bottom = matrix.length - 1;
            int right = matrix[0].length - 1;
            while (top <= bottom && left <= right) {
                int x = (left + right) / 2;
                int y = (top + bottom) / 2;
                if (matrix[x][y] == target) {
                    return new int[] {x, y};
                }

            }
            return new int[] {-1, -1};
        }
    }

    class Solution2 implements SearchInSortedMatrix {

        @Override
        public int[] searchInSortedMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                int index = binarySearch(matrix[i], target);
                if (index >= 0) {
                    return new int[] {i, index};
                }
            }
            return new int[] {-1, -1};
        }

        private int binarySearch(int[] array, int target) {
            int start = 0;
            int end = array.length - 1;
            while (start < end - 1) {
                int index = (start + end) / 2;
                if (array[index] == target) return index;
                if (target < array[index]) {
                    end = index;
                } else {
                    start = index;
                }
            }
            if (array[start] == target) return start;
            if (array[end] == target) return end;
            return -1;
        }
    }
}
