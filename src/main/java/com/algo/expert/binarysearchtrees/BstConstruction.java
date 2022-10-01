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
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
                return this;
            }

            if (value > this.value) {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
                return this;
            }

            BST right = this.right;
            this.right = new BST(value);
            this.right.right = right;
            return this;
        }

        public BST remove(int value) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value);
                }
                return this;
            }

            if (value > this.value) {
                if (right != null) {
                    right.remove(value);
                }
                return this;
            }

            if (right != null) {
                BST latestLeft = right;
                BST clearLeft = null;
                while (latestLeft.left != null) {
                    clearLeft = latestLeft;
                    latestLeft = latestLeft.left;
                }
                this.value = latestLeft.value;
                if (clearLeft == null) {
                    this.right = latestLeft.right;
                } else {
                    clearLeft.left = null;
                }
            } else if (left != null) {
                this.value = left.value;
                this.right = left.right;
                this.left = left.left;
            }
            return this;
        }

        public boolean contains(int value) {
            if (value < this.value) {
                return left != null && left.contains(value);
            }
            if (value > this.value) {
                return right != null && right.contains(value);
            }
            return true;
        }
    }
}
