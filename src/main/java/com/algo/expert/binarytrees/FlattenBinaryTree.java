package com.algo.expert.binarytrees;

public interface FlattenBinaryTree {

    BinaryTree flattenBinaryTree(BinaryTree root);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements FlattenBinaryTree {

        @Override
        public BinaryTree flattenBinaryTree(BinaryTree root) {
            return internalFlattenBinaryTree(root).first;
        }

        private FlattenedBinaryTree internalFlattenBinaryTree(BinaryTree root) {
            if (root == null) return new FlattenedBinaryTree(null, null);
            var flattenedLeft = internalFlattenBinaryTree(root.left);
            var flattenedRight = internalFlattenBinaryTree(root.right);
            if (flattenedLeft.last != null) {
                flattenedLeft.last.right = root;
            }
            root.left = flattenedLeft.last;
            root.right = flattenedRight.first;
            if (flattenedRight.first != null) {
                flattenedRight.first.left = root;
            }
            var first = flattenedLeft.first == null ? root : flattenedLeft.first;
            var last = flattenedRight.last == null ? root : flattenedRight.last;
            return new FlattenedBinaryTree(first, last);
        }

        private static class FlattenedBinaryTree {
            final BinaryTree first;
            final BinaryTree last;

            public FlattenedBinaryTree(BinaryTree first, BinaryTree last) {
                this.first = first;
                this.last = last;
            }
        }
    }
}
