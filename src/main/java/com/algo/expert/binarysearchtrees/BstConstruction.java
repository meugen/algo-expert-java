package com.algo.expert.binarysearchtrees;

public interface BstConstruction {

    class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            return this;
        }

        public BST remove(int value) {
            return this;
        }

        public boolean contains(int value) {
            return false;
        }
    }
}
