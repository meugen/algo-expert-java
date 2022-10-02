package com.algo.expert.recurtion;

import java.util.*;

public interface Permutations {

    List<List<Integer>> getPermutations(List<Integer> array);

    class Solution1 implements Permutations {

        private List<List<Integer>> result;
        private List<Integer> array;

        @Override
        public List<List<Integer>> getPermutations(List<Integer> array) {
            if (array.isEmpty()) return Collections.emptyList();

            Set<Integer> indexes = new TreeSet<>();
            for (int i = 0; i < array.size(); i++) {
                indexes.add(i);
            }

            this.array = array;
            this.result = new ArrayList<>();
            getPermutationsTo(new ArrayList<>(), indexes);
            return result;
        }

        private void getPermutationsTo(List<Integer> permutation, Set<Integer> indexes) {
            if (indexes.isEmpty()) {
                result.add(new ArrayList<>(permutation));
                return;
            }
            for (Integer index : indexes) {
                try {
                    Set<Integer> newIndexes = new TreeSet<>(indexes);
                    newIndexes.remove(index);
                    permutation.add(array.get(index));
                    getPermutationsTo(permutation, newIndexes);
                } finally {
                    permutation.remove(permutation.size() - 1);
                }
            }
        }
    }
}
