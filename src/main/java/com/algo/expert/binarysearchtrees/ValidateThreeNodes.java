package com.algo.expert.binarysearchtrees;

public interface ValidateThreeNodes {
    
    class BST {
        public final int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree);

    class Solution1 implements ValidateThreeNodes {

        @Override
        public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
            if (validateDescendant(nodeTwo, nodeOne) && validateDescendant(nodeThree, nodeTwo)) {
                return true;
            }
            if (validateDescendant(nodeTwo, nodeThree) && validateDescendant(nodeOne, nodeTwo)) {
                return true;
            }
            return false;
        }

        private boolean validateDescendant(BST one, BST two) {
            BST cur = one;
            while (true) {
                if (cur == two) return true;
                if (two.value >= cur.value && cur.right == null) return false;
                if (two.value < cur.value && cur.left == null) return false;
                cur = two.value >= cur.value ? cur.right : cur.left;
            }
        }
    }
}
