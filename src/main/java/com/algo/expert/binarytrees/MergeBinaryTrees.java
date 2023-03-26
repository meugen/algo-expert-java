package com.algo.expert.binarytrees;

public interface MergeBinaryTrees {

    BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements MergeBinaryTrees {

        @Override
        public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
            if (tree1 == null && tree2 == null) return null;
            var result = new BinaryTree(getValue(tree1) + getValue(tree2));
            result.left = mergeBinaryTrees(goLeft(tree1), goLeft(tree2));
            result.right = mergeBinaryTrees(goRight(tree1), goRight(tree2));
            return result;
        }

        private int getValue(BinaryTree item) {
            return item == null ? 0 : item.value;
        }

        private BinaryTree goLeft(BinaryTree item) {
            return item == null ? null : item.left;
        }

        private BinaryTree goRight(BinaryTree item) {
            return item == null ? null : item.right;
        }
    }
}
