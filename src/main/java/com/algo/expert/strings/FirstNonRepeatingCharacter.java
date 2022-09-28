package com.algo.expert.strings;

import java.util.HashMap;
import java.util.Map;

public interface FirstNonRepeatingCharacter {

    int firstNonRepeatingCharacter(String string);

    class Solution1 implements FirstNonRepeatingCharacter {

        @Override
        public int firstNonRepeatingCharacter(String string) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : string.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (int i=0; i<string.length(); i++) {
                if (map.get(string.charAt(i)) == 1) return i;
            }
            return -1;
        }
    }
}
