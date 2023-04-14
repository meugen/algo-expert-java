package com.algo.expert.binarytrees;

public interface SplitBinaryTree {

    int splitBinaryTree(BinaryTree tree);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements SplitBinaryTree {

        @Override
        public int splitBinaryTree(BinaryTree tree) {
            try {
                calculateTreeSum(tree, 0);
                return 0;
            } catch (FoundResultException e) {
                return e.sum;
            }
        }

        private int calculateTreeSum(BinaryTree item, Integer otherTreeSum) throws FoundResultException {
            if (item == null) return 0;
            var newOtherTreeSum = nullableSum(otherTreeSum, item.value);
            int leftSum = calculateTreeSum(item.left, null);
            int rightSum = calculateTreeSum(item.right, nullableSum(newOtherTreeSum, leftSum));
            calculateTreeSum(item.left, nullableSum(newOtherTreeSum, rightSum));
            int treeSum = leftSum + item.value + rightSum;
            if (otherTreeSum != null && treeSum == otherTreeSum) {
                throw new FoundResultException(otherTreeSum);
            }
            return treeSum;
        }

        private Integer nullableSum(Integer value1, Integer value2) {
            if (value1 == null || value2 == null) return null;
            return value1 + value2;
        }

        private static class FoundResultException extends Exception {
            final int sum;

            public FoundResultException(int sum) {
                this.sum = sum;
            }
        }
    }
}
