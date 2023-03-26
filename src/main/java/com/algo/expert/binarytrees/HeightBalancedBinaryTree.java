package com.algo.expert.binarytrees;

public interface HeightBalancedBinaryTree {

    boolean heightBalancedBinaryTree(BinaryTree tree);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements HeightBalancedBinaryTree {

        @Override
        public boolean heightBalancedBinaryTree(BinaryTree tree) {
            return binaryTreeItemResult(tree).balanced;
        }

        private ItemResult binaryTreeItemResult(BinaryTree item) {
            if (item == null) return new ItemResult(true, 0);
            var leftResult = binaryTreeItemResult(item.left);
            var rightResult = binaryTreeItemResult(item.right);
            var height = 1 + Math.max(leftResult.height, rightResult.height);
            var balanced = leftResult.balanced && rightResult.balanced
                    && Math.abs(leftResult.height - rightResult.height) <= 1;
            return new ItemResult(balanced, height);
        }

        private static class ItemResult {
            final boolean balanced;
            final int height;

            public ItemResult(boolean balanced, int height) {
                this.balanced = balanced;
                this.height = height;
            }
        }
    }
}
