package com.algo.expert.binarysearchtrees;

public interface FindClosestValueBst {

    int findClosestValueInBst(BST tree, int target);

    class Solution1 implements FindClosestValueBst {

        @Override
        public int findClosestValueInBst(BST tree, int target) {
            return findClosestCheckDiffer(tree, target, target-tree.value);
        }

        private int findClosestCheckDiffer(BST tree, int target, int closestDiffer) {
            if (tree.value==target) return target;
            if (Math.abs(target-tree.value) < Math.abs(closestDiffer)) closestDiffer = target-tree.value;
            if (target<tree.value && tree.left!=null) return findClosestCheckDiffer(tree.left, target, closestDiffer);
            if (target>tree.value && tree.right!=null) return findClosestCheckDiffer(tree.right, target, closestDiffer);
            return target - closestDiffer;
        }
    }

    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
