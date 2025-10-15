package com.algo.expert.binarysearchtrees;

public interface SumBsts {

    int sumBsts(BinaryTree tree);
    
    class BinaryTree {
        public final int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution implements SumBsts {

        @Override
        public int sumBsts(BinaryTree tree) {
            return buildResult(tree, Integer.MIN_VALUE, Integer.MAX_VALUE).sum;
        }

        private Result buildResult(BinaryTree tree, int min, int max) {
            if (tree == null) return new Result(true, 0);
            Result leftResult = buildResult(tree.left, min, tree.value);
            Result rightResult = buildResult(tree.right, tree.value, max);
            boolean valid = leftResult.valid && rightResult.valid;
            int sum = (valid ? tree.value : 0) + leftResult.sum + rightResult.sum; 
            return new Result(valid, sum);
        }

        private static class Result {
            final boolean valid;
            final int sum;

            Result(boolean valid, int sum) {
                this.valid = valid;
                this.sum = sum;
            }
        }
    }
}
