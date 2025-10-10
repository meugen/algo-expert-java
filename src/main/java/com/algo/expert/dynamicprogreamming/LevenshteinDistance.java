package com.algo.expert.dynamicprogreamming;

import java.util.ArrayList;

public interface LevenshteinDistance {
    
    int levenshteinDistance(String str1, String str2);

    class Solution1 implements LevenshteinDistance {

        @Override
        public int levenshteinDistance(String str1, String str2) {
            var chars1 = new ArrayList<Integer>();
            str1.chars().forEach(chars1::add);
            var chars2Count = 0;
            for (char c :  str2.toCharArray()) {
                if (chars1.contains(Integer.valueOf(c))) {
                    chars1.remove(Integer.valueOf(c));
                } else {
                    chars2Count++;
                }
            }
            return Math.max(chars1.size(), chars2Count);
        }
    }
}
