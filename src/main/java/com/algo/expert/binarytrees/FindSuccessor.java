package com.algo.expert.binarytrees;

public interface FindSuccessor {

    BinaryTree findSuccessor(BinaryTree tree, BinaryTree node);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements FindSuccessor {

        private boolean nextSuccessor = false;

        @Override
        public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
            try {
                internalFindSuccessor(tree, node);
            } catch (FoundException e) {
                return e.successor;
            }
            return null;
        }

        private void internalFindSuccessor(BinaryTree item, BinaryTree node) throws FoundException {
            if (item == null) return;
            internalFindSuccessor(item.left, node);
            if (nextSuccessor) {
                throw new FoundException(item);
            }
            nextSuccessor = item == node;
            internalFindSuccessor(item.right, node);
        }

        private static class FoundException extends Exception {
            final BinaryTree successor;

            public FoundException(BinaryTree successor) {
                this.successor = successor;
            }
        }
    }

    class Solution2 implements FindSuccessor {

        @Override
        public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
            var result = findMostLeft(node.right);
            if (result != null) return result;

            BinaryTree prev = null;
            result = node;
            while (result != null && (result.left == null || result.left != prev)) {
                prev = result;
                result = result.parent;
            }
            return result;
        }

        private BinaryTree findMostLeft(BinaryTree node) {
            if (node == null) return null;
            var result = node;
            var next = node.left;
            while (next != null) {
                result = next;
                next = next.left;
            }
            return result;
        }
    }
}
