package com.algo.expert.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public interface MergeSortedArrays {

    List<Integer> mergeSortedArrays(List<List<Integer>> arrays);

    class Solution1 implements MergeSortedArrays {

        @Override
        public List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
            var result = arrays.get(0);
            for (int i = 1; i < arrays.size(); i++) {
                result = mergeTwoArrays(result, arrays.get(i));
            }
            return result;
        }

        private List<Integer> mergeTwoArrays(List<Integer> array1, List<Integer> array2) {
            var result = new ArrayList<Integer>(array1.size() + array2.size());
            int index1 = 0;
            int index2 = 0;
            while (index1 < array1.size() || index2 < array2.size()) {
                if (index1 < array1.size()) {
                    int end2 = index2;
                    while (end2 < array2.size() && array2.get(end2) <= array1.get(index1)) {
                        end2++;
                    }
                    result.addAll(array2.subList(index2, end2));
                    index2 = end2;
                } else {
                    result.addAll(array2.subList(index2, array2.size()));
                    index2 = array2.size();
                }
                if (index2 < array2.size()) {
                    int end1 = index1;
                    while (end1 < array1.size() && array1.get(end1) <= array2.get(index2)) {
                        end1++;
                    }
                    result.addAll(array1.subList(index1, end1));
                    index1 = end1;
                } else if (index1 < array1.size()) {
                    result.addAll(array1.subList(index1, array1.size()));
                    index1 = array1.size();
                }
            }
            return result;
        }
    }
}
