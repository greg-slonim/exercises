package com.gslonim.coding.strings;

public class CompressedStringComparison {
    public static boolean isEqualToCompressedString(String compressed, String literal) {
        String[] tokenized = literal.split("");
        StringBuilder comparison = new StringBuilder();
        int letterCount = 1;

        for (String letter : tokenized) {
            if (comparison.length() != 0 && comparison.indexOf(letter) == comparison.length() - 1) {
                letterCount ++;
            } else {
                comparison
                        .append(letterCount != 1 ? letterCount : "")
                        .append(letter);
                letterCount = 1;
            }
        }
        comparison.append(letterCount != 1 ? letterCount : "");

        return comparison.toString().equalsIgnoreCase(compressed);
    }

    public static boolean isEqualToCompressedStringV2(String compressed, String literal) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < literal.length() - 1; i++) {
            int count = 1;
            char current = literal.charAt(i);
            while (current == literal.charAt(i + 1)) {
                i++;
                count++;
                if (i +1 == literal.length()) {
                    break;
                }
            }
            sb.append(current).append(count != 1 ? count : "");
        }
        return sb.toString().equalsIgnoreCase(compressed);
    }

    public static void main(String[] args) {
        System.out.println("Strings are the same: "
                + isEqualToCompressedString("a3bc6d2f2", "aaabccccccddff"));
        System.out.println("Strings are the same: "
                + isEqualToCompressedStringV2("a3bc6d2f2", "aaabccccccddff"));
    }
}
