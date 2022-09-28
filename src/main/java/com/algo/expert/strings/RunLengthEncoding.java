package com.algo.expert.strings;

public interface RunLengthEncoding {

    String runLengthEncoding(String string);

    class Solution1 implements RunLengthEncoding {

        @Override
        public String runLengthEncoding(String string) {
            StringBuilder builder = new StringBuilder();
            int startIndex = 0;
            char currentChar = string.charAt(0);
            for (int i=1; i<string.length(); i++) {
                if (string.charAt(i) != currentChar || i - startIndex + 1 >= 10) {
                    builder.append(i - startIndex);
                    builder.append(currentChar);
                    startIndex = i;
                    currentChar = string.charAt(i);
                }
            }
            builder.append(string.length() - startIndex);
            builder.append(currentChar);
            return builder.toString();
        }
    }
}
