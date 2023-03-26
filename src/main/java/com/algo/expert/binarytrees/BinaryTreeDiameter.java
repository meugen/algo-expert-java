package com.algo.expert.binarytrees;

public interface BinaryTreeDiameter {

    int binaryTreeDiameter(BinaryTree tree);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements BinaryTreeDiameter {

        @Override
        public int binaryTreeDiameter(BinaryTree tree) {
            return binaryTreeItemResult(tree).diameter;
        }

        private ItemResult binaryTreeItemResult(BinaryTree item) {
            if (item == null) return new ItemResult(0, 0);
            var leftResult = binaryTreeItemResult(item.left);
            var rightResult = binaryTreeItemResult(item.right);
            var diameter = Math.max(leftResult.diameter, rightResult.diameter);
            diameter = Math.max(diameter, leftResult.longestPath + rightResult.longestPath);
            var longestPath = 1 + Math.max(leftResult.longestPath, rightResult.longestPath);
            return new ItemResult(diameter, longestPath);
        }

        private static class ItemResult {
            final int diameter;
            final int longestPath;

            public ItemResult(int diameter, int longestPath) {
                this.diameter = diameter;
                this.longestPath = longestPath;
            }
        }
    }
}
