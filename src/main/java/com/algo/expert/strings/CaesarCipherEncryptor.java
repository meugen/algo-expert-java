package com.algo.expert.strings;

public class CaesarCipherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            int newChar = (c + key - 'a') % ('z' - 'a' + 1) + 'a';
            builder.append((char) newChar);
        }
        return builder.toString();
    }
}
