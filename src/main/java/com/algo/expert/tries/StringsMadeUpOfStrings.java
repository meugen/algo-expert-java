package com.algo.expert.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StringsMadeUpOfStrings {
    
    String[] stringsMadeUpOfStrings(String[] strings, String[] substrings);

    class Solution1 implements StringsMadeUpOfStrings {

        @Override
        public String[] stringsMadeUpOfStrings(String[] strings, String[] substrings) {
            var map = new HashMap<Character, List<String>>();
            for (String substring : substrings) {
                var list = map.getOrDefault(substring.charAt(0), new ArrayList<>());
                list.add(substring);
                map.put(substring.charAt(0), list);
            }

            var result = new ArrayList<String>();
            for (String string : strings) {
                if (checkStringMadeUpSubstrings(string, map)) {
                    result.add(string);
                }
            }
            return result.toArray(new String[result.size()]);
        }

        private boolean checkStringMadeUpSubstrings(String string, Map<Character, List<String>> substrings) {
            var list = substrings.get(string.charAt(0));
            if (list == null) return false;
            for (String substring : list) {
                if (string.startsWith(substring)) {
                    var newString = string.substring(substring.length());
                    if (newString.isEmpty() || checkStringMadeUpSubstrings(newString, substrings)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
