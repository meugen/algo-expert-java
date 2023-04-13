package com.algo.expert.binarytrees;

public interface EvaluateExpressionTree {

    int evaluateExpressionTree(BinaryTree tree);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements EvaluateExpressionTree {

        @Override
        public int evaluateExpressionTree(BinaryTree tree) {
            if (tree.value > 0) return tree.value;
            int leftValue = evaluateExpressionTree(tree.left);
            int rightValue = evaluateExpressionTree(tree.right);
            if (tree.value == -1) {
                return leftValue + rightValue;
            }
            if (tree.value == -2) {
                return leftValue - rightValue;
            }
            if (tree.value == -3) {
                return leftValue / rightValue;
            }
            if (tree.value == -4) {
                return leftValue * rightValue;
            }
            throw new RuntimeException();
        }
    }
}
