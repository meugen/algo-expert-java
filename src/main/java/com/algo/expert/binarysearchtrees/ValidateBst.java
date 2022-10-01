package com.algo.expert.binarysearchtrees;

public interface ValidateBst {

    boolean validateBst(BST tree);

    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    class Solution1 implements ValidateBst {

        @Override
        public boolean validateBst(BST tree) {
            return validateValueBetween(tree.left, Integer.MIN_VALUE, tree.value - 1)
                    && validateValueBetween(tree.right, tree.value, Integer.MAX_VALUE);
        }

        private boolean validateValueBetween(BST node, int min, int max) {
            if (node == null) return true;
            if (node.value < min || node.value > max) return false;
            return validateValueBetween(node.left, min, node.value - 1)
                    && validateValueBetween(node.right, node.value, max);
        }
    }
}
