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
            var result = buildResult(tree);
            return result.count >= 3 ? result.sum : 0;
        }

        private Result buildResult(BinaryTree tree) {
            if (tree == null) return null;
            var leftResult = buildResult(tree.left);
            var rightResult = buildResult(tree.right);
            var valid = (leftResult == null || (leftResult.valid && leftResult.min < tree.value &&  leftResult.max < tree.value))
                && (rightResult == null || (rightResult.valid && tree.value <= rightResult.min && tree.value <= rightResult.max));
            var min = Math.min(tree.value, leftResult == null ? Integer.MAX_VALUE : leftResult.min);
            var max = Math.max(tree.value, rightResult == null ? Integer.MIN_VALUE : rightResult.max);
            var sum = valid ? tree.value : 0;
            sum += leftResult == null || (!valid && leftResult.count < 3) ? 0 : leftResult.sum;
            sum += rightResult == null || (!valid && rightResult.count < 3) ? 0 : rightResult.sum;
            var count = 1;
            count += leftResult == null ? 0 : leftResult.count;
            count += rightResult == null ? 0 : rightResult.count;
            return new Result(valid, min, max, sum, count);
        }

        private static class Result {
            final boolean valid;
            final int min;
            final int max;
            final int sum;
            final int count;

            Result(boolean valid, int min, int max, int sum, int count) {
                this.valid = valid;
                this.min = min;
                this.max = max;
                this.sum = sum;
                this.count = count;
            }
        }
    }
}
