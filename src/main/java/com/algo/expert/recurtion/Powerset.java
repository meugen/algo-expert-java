package com.algo.expert.recurtion;

import java.util.*;

public interface Powerset {

    List<List<Integer>> powerset(List<Integer> array);

    class Solution implements Powerset {

        @Override
        public List<List<Integer>> powerset(List<Integer> array) {
            var result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<>(array.size()));
            buildResult(array, 0, result, new ArrayList<>());
            return result;
        }

        private void buildResult(List<Integer> array, int index, List<List<Integer>> result, List<Integer> temp) {
            for (int i = index; i < array.size(); i++) {
                temp.add(array.get(i));
                result.add(new ArrayList<>(temp));
                buildResult(array, i + 1, result, temp);
                temp.remove(array.get(i));
            }
        }
        
    }
}
