package com.algo.expert.binarytrees;

public interface MaxPathSumInBinaryTree {

    int maxPathSum(BinaryTree tree);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements MaxPathSumInBinaryTree {

        @Override
        public int maxPathSum(BinaryTree tree) {
            return calculatePathInfo(tree).internalPathMaxSum;
        }

        private PathInfo calculatePathInfo(BinaryTree item) {
            if (item == null) return new PathInfo(Integer.MIN_VALUE, 0);
            var leftPath = calculatePathInfo(item.left);
            var rightPath = calculatePathInfo(item.right);
            var linearMaxPath = item.value + Math.max(leftPath.linearPathMaxSum, rightPath.linearPathMaxSum);
            var internalMaxPath = Math.max(leftPath.internalPathMaxSum, rightPath.internalPathMaxSum);
            internalMaxPath = Math.max(internalMaxPath, item.value
                    + Math.max(leftPath.linearPathMaxSum, 0)
                    + Math.max(rightPath.linearPathMaxSum, 0));
            return new PathInfo(internalMaxPath, linearMaxPath);
        }

        private static class PathInfo {
            final int internalPathMaxSum;
            final int linearPathMaxSum;

            public PathInfo(int internalPathMaxSum, int linearPathMaxSum) {
                this.internalPathMaxSum = internalPathMaxSum;
                this.linearPathMaxSum = linearPathMaxSum;
            }
        }
    }
}
