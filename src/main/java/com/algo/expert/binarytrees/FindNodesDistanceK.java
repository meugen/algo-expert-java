package com.algo.expert.binarytrees;

import java.util.*;

public interface FindNodesDistanceK {

    List<Integer> findNodesDistanceK(BinaryTree tree, int target, int k);

    class BinaryTree {
        public final int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    class Solution1 implements FindNodesDistanceK {

        @Override
        public List<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
            var targetInfo = findTarget(new ArrayList<>(), tree, target);
            if (targetInfo == null) return new ArrayList<>();
            return makeAllSteps(targetInfo.parents, targetInfo.targetItem, k, Collections.emptySet());
        }

        private TargetInfo findTarget(List<BinaryTree> parents, BinaryTree item, int target) {
            if (item == null) return null;
            if (item.value == target) return new TargetInfo(parents, item);
            var newParents = new ArrayList<>(parents);
            newParents.add(item);
            var result = findTarget(newParents, item.left, target);
            if (result != null) return result;
            result = findTarget(newParents, item.right, target);
            return result;
        }

        private List<Integer> makeAllSteps(List<BinaryTree> parents, BinaryTree item, int k, Set<Integer> excludes) {
            if (item == null || excludes.contains(item.value)) return Collections.emptyList();
            if (k == 0) return Collections.singletonList(item.value);
            var result = new ArrayList<Integer>();
            result.addAll(makeStepUp(parents, item, k));
            result.addAll(makeStepLeft(item, k, excludes));
            result.addAll(makeStepRight(item, k, excludes));
            return result;
        }

        private List<Integer> makeStepUp(List<BinaryTree> parents, BinaryTree item, int k) {
            if (parents.isEmpty()) return Collections.emptyList();
            var newParents = new LinkedList<>(parents);
            var parent = newParents.removeLast();
            return makeAllSteps(newParents, parent, k - 1, Collections.singleton(item.value));
        }

        private List<Integer> makeStepLeft(BinaryTree item, int k, Set<Integer> excludes) {
            return makeAllSteps(Collections.emptyList(), item.left, k - 1, excludes);
        }

        private List<Integer> makeStepRight(BinaryTree item, int k, Set<Integer> excludes) {
            return makeAllSteps(Collections.emptyList(), item.right, k - 1, excludes);
        }

        static class TargetInfo {
            final List<BinaryTree> parents;
            final BinaryTree targetItem;

            public TargetInfo(List<BinaryTree> parents, BinaryTree targetItem) {
                this.parents = parents;
                this.targetItem = targetItem;
            }
        }
    }
}
