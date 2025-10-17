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
            if (left == null && right == null) {
                return this;
            }

            ParentBST toRemove = findNode(value);
            if (toRemove.current == null) {
                return this;
            }
            ParentBST replaceTo = new ParentBST(toRemove);
            if (toRemove.current.right != null) {
                replaceTo.doNext(toRemove.current.right);
                replaceTo.findMostLeft();
                replaceTo.parent.left = replaceTo.current.left;
            } else if (toRemove.current.left != null) {
                replaceTo.doNext(toRemove.current.left);
                replaceTo.findMostRight();
                replaceTo.parent.right = replaceTo.current.right;
            } else if (replaceTo.parent != null) {
                if (value < replaceTo.parent.value) {
                    replaceTo.parent.left = null;
                } else {
                    replaceTo.parent.right = null;
                }
            }
            toRemove.current.value = replaceTo.current.value;
            return this;
        }

        public boolean contains(int value) {
            return findNode(value).current != null;
        }

        private ParentBST findNode(int value) {
            ParentBST result = new ParentBST(this);
            while (result.current != null && result.current.value != value) {
                if (value < result.current.value) {
                    result.doNext(result.current.left);
                } else {
                    result.doNext(result.current.right);
                }
            }
            return result;
        }
    }

    static class ParentBST {
        BST parent;
        BST current;

        ParentBST(ParentBST parentBST) {
            this(parentBST.current, parentBST.parent);
        }

        ParentBST(BST current) {
            this(current, null);
        }

        ParentBST(BST current, BST parent) {
            this.current = current;
            this.parent = parent;
        }

        void doNext(BST next) {
            this.parent = this.current;
            this.current = next;
        }

        void findMostLeft() {
            while (this.current.left != null) {
                doNext(this.current.left);
            }
        }

        void findMostRight() {
            while (this.current.right != null) {
                doNext(this.current.right);
            }
        }
    }
}
