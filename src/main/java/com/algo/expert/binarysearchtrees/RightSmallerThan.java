package com.algo.expert.binarysearchtrees;

import java.util.*;

public interface RightSmallerThan {
    
    List<Integer> rightSmallerThan(List<Integer> array);

    class Solution implements RightSmallerThan {

        @Override
        public List<Integer> rightSmallerThan(List<Integer> array) {
            var result = new LinkedList<Integer>();
            BST root = null;
            for (int i = array.size() - 1; i >= 0; i--) {
                root = insertItem(root, array.get(i), 0, result);
            }
            return result;
        }

        private BST insertItem(BST tree, int value, int leftCount, List<Integer> result) {
            if (tree == null) {
                result.add(0, leftCount);
                return new BST(value);
            }
            if (value < tree.value) {
                tree.left = insertItem(tree.left, value, leftCount, result);
                tree.leftCount++;
            } else {
                var newLeftCount = (tree.value < value ? 1 : 0) + leftCount + tree.leftCount;
                tree.right = insertItem(tree.right, value, newLeftCount, result);
            }
            return tree;
        }

        private static class BST {
            final int value;
            BST left = null;
            BST right = null;
            int leftCount = 0;

            BST(int value) {
                this.value = value;
            }
        }
        
    }
}
