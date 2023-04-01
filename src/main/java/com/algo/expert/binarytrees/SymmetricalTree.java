package com.algo.expert.binarytrees;

public interface SymmetricalTree {

    boolean symmetricalTree(BinaryTree tree);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements SymmetricalTree {

        @Override
        public boolean symmetricalTree(BinaryTree tree) {
            return isItemsSymmetrical(tree.left, tree.right);
        }

        private boolean isItemsSymmetrical(BinaryTree item1, BinaryTree item2) {
            if (item1 == null && item2 == null) return true;
            if (item1 == null || item2 == null) return false;
            boolean result = item1.value == item2.value;
            result = result && isItemsSymmetrical(item1.left, item2.right);
            result = result && isItemsSymmetrical(item1.right, item2.left);
            return result;
        }
    }
}
