package com.algo.expert.strings;

public interface PalindromeCheck {

    boolean isPalindrome(String str);

    class Solution1 implements PalindromeCheck {

        @Override
        public boolean isPalindrome(String str) {
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
}
