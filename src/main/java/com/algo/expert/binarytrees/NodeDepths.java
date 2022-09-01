package com.algo.expert.binarytrees;

public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return nodeDepthSum(root, 0);
    }

    private static int nodeDepthSum(BinaryTree tree, int depth) {
        int result = depth;
        if (tree.left != null) result += nodeDepthSum(tree.left, depth+1);
        if (tree.right != null) result += nodeDepthSum(tree.right, depth+1);
        return result;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
