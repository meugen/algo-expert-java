package com.algo.expert.strings;

import java.util.HashMap;
import java.util.Map;

public interface GenerateDocument {

    boolean generateDocument(String characters, String document);

    class Solution1 implements  GenerateDocument {

        @Override
        public boolean generateDocument(String characters, String document) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : characters.toCharArray()) {
                map.merge(c, 1, Integer::sum);
            }

            for (char c : document.toCharArray()) {
                Integer count = map.get(c);
                if (count == null || count == 0) {
                    return false;
                }
                map.put(c, count-1);
            }
            return true;
        }
    }
}
