package com.gslonim.coding.strings;

import java.util.HashSet;
import java.util.Set;

//TODO
public class Abbreviate_String {
    public static String canAbbreviate(String a, String b) {
        Set<Character> dict = new HashSet<>();
        for (int i = 0; i < b.length(); i++) {
            dict.add(b.charAt(i));
        }

        for (int i = 0; i < a.length(); i++) {
            char current = Character.toUpperCase(a.charAt(i));
            if (!dict.contains(current)) {
                return "NO";
            }
        }
        return "";
    }
}
