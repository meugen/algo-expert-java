package com.algo.expert.binarytrees;

public interface RightSiblingTree {

    BinaryTree rightSiblingTree(BinaryTree tree);
    
    class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements RightSiblingTree {

        @Override
        public BinaryTree rightSiblingTree(BinaryTree tree) {
            var children = new BinaryTreeChildren(new BinaryTree[] { tree }, true);
            while (children.hasNonNull) {
                children = collectChildren(children.children);
            }
            return tree;
        }

        private BinaryTreeChildren collectChildren(BinaryTree[] parents) {
            BinaryTree[] result = new BinaryTree[parents.length * 2];
            boolean hasNonNull = false;
            for (int i = 0; i < parents.length; i++) {
                result[i * 2] = parents[i] == null ? null : parents[i].left;
                result[i * 2 + 1] = parents[i] == null ? null : parents[i].right;
                if (parents[i] != null) {
                    parents[i].right = i + 1 < parents.length ? parents[i + 1] : null;
                    hasNonNull = true;
                }
            }
            return new BinaryTreeChildren(result, hasNonNull);
        }

        private static class BinaryTreeChildren {
            final BinaryTree[] children;
            final boolean hasNonNull;

            BinaryTreeChildren(BinaryTree[] children, boolean hasNonNull) {
                this.children = children;
                this.hasNonNull = hasNonNull;
            }
        }
    }
}
