package com.gslonim.coding.strings;

public class Two_Strings_One_Edit_Away {
    public static boolean isOneEditAway(String one, String two) {
        if (Math.abs(one.length() - two.length()) > 1) {
            return false;
        }
        String longer = one.length() > two.length() ? one : two;
        String shorter = one.length() > two.length() ? two : one;
        if (longer.length() > shorter.length()) {
            return compareForInsertion(longer, shorter);
        }
        return compareForReplacement(longer, shorter);
    }

    private static boolean compareForReplacement(String one, String two) {
        int diffCounter = 0;
        for (int i = 0; i < one.length(); i++) {
            Character left = one.charAt(i);
            Character right = two.charAt(i);
            if (left != right) {
                diffCounter++;
            }
        }
        return diffCounter <= 1;
    }

    private static boolean compareForInsertion(String longer, String shorter) {
        int diffCounter = 0, longIndex = 0, shortIndex = 0;
        while (shortIndex < shorter.length() && longIndex < longer.length()) {
            Character left = shorter.charAt(shortIndex);
            Character right = longer.charAt(longIndex);
            if (left != right) {
                diffCounter++;
                longIndex++;
            } else {
                longIndex++;
                shortIndex++;
            }
        }
        return diffCounter <= 1;
    }


}
