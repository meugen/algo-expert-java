package com.algo.expert.strings;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        int index = 0;
        while (index <str.length()/2) {
            if (str.charAt(index) != str.charAt(str.length()-index-1)) {
                return false;
            }
            index++;
        }
        return true;
    }
}
