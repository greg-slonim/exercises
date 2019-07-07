package com.gslonim.algo;

public class PalindromeTools {
    public boolean isPalindrome(String word) {

        String spacesRemoved = word.replaceAll(" *", "");
        StringBuilder builder = new StringBuilder(spacesRemoved);
        if (spacesRemoved.equalsIgnoreCase(builder.reverse().toString())) {
            return true;
        }

        return false;
    }
}
