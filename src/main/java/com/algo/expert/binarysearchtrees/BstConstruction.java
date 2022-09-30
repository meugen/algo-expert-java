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
                BST oldLeft = this.left;
                this.value = right.value;
                this.left = right.left;
                this.right = right.right;
                BST latestLeft = this;
                while (latestLeft.left != null) {
                    latestLeft = latestLeft.left;
                }
                latestLeft.left = oldLeft;
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
