package com.algo.expert.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> list = new ArrayList<>();
        branchSumsTo(root, list, 0);
        return list;
    }

    private static void branchSumsTo(BinaryTree item, List<Integer> list, int sum) {
        sum += item.value;
        if (item.left == null && item.right == null) {
            list.add(sum);
            return;
        }
        if (item.left != null) branchSumsTo(item.left, list, sum);
        if (item.right != null) branchSumsTo(item.right, list, sum);
    }
}
