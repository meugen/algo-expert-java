package com.algo.expert.binarytrees;

public interface InvertBinaryTree {

    void invertBinaryTree(BinaryTree tree);

    class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements InvertBinaryTree {
        @Override
        public void invertBinaryTree(BinaryTree tree) {
            if (tree.left != null) {
                invertBinaryTree(tree.left);
            }
            if (tree.right != null) {
                invertBinaryTree(tree.right);
            }
            BinaryTree temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
        }
    }
}
