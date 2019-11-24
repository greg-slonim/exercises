package com.gslonim.coding.algo.easy;

public class PseudoCompressedStringComparison {
    public static void main(String[] args) {
        System.out.println("advertising " + "a9g " + kurbanVersion("advertising", "a9g"));
        System.out.println("advertising " + "a9g " + gregVersion("advertising", "a9g"));

        System.out.println("advertising " + "a7ng " + kurbanVersion("advertising", "a7ng"));
        System.out.println("advertising " + "a7ng " + gregVersion("advertising", "a7ng"));

        System.out.println("advertising " + "11 " + kurbanVersion("advertising", "11"));
        System.out.println("advertising " + "11 " + gregVersion("advertising", "11"));

        System.out.println("ad " + "ad0 " + kurbanVersion("ad", "ad0"));
        System.out.println("ad " + "ad0 " + gregVersion("ad", "ad0"));

        System.out.println("adver " + "ad0ver " + kurbanVersion("adver", "ad0ver"));
        System.out.println("adver " + "ad0ver " + gregVersion("adver", "ad0ver"));

        System.out.println("advertising " + "ad3ti3g " + kurbanVersion("advertising", "ad3ti3g"));
        System.out.println("advertising " + "ad3ti3g " + gregVersion("advertising", "ad3ti3g"));
    }

    private static boolean gregVersion(String literal, String compressed) {
        int compressedLength = compressed.length();
        int literalLength = literal.length();
        int litPointer = 0, compPointer = 0;

        //Edge case - compressed is a number
        if (compressedIsNumberEqualToLiteralLength(literalLength, compressed)) {
            return true;
        }
        //Edge case - compressed ends with 0
        if (compressed.endsWith("0")) {
            return compressed.substring(0, compressed.lastIndexOf("0")).equals(literal);
        }

        // Main loop
        while (litPointer < literalLength && compPointer < compressedLength) {
            if (Character.isDigit(compressed.charAt(compPointer))) {
                int numericSkip = Character.getNumericValue(compressed.charAt(compPointer));
                if (numericSkip != 0) {
                    litPointer += numericSkip;
                }
                compPointer++;
            } else if (charactersAreLettersAndTheSame(compressed.charAt(compPointer), literal.charAt(litPointer))) {
                litPointer++;
                compPointer++;
            } else {
                return false;
            }
        }
        return litPointer == literalLength && compPointer == compressedLength;
    }

    private static boolean compressedIsNumberEqualToLiteralLength(int literalLength, String compressed) {
        int numericValue;
        try {
            numericValue = Integer.parseInt(compressed);
        } catch (NumberFormatException e) {
            return false;
        }
        return numericValue == literalLength;
    }

    private static boolean charactersAreLettersAndTheSame(char compressed, char literal) {
        return !Character.isDigit(compressed) && compressed == literal;
    }

    private static boolean kurbanVersion(String literal, String compressed) {
        int cPointer = 0, lPointer = 0;

        while (cPointer < compressed.length() && lPointer < literal.length()) {
            if (Character.isDigit(compressed.charAt(cPointer))) {
                int skipBy = 0;
                while (cPointer < compressed.length() && Character.isDigit(compressed.charAt(cPointer))) {
                    skipBy = Character.getNumericValue(compressed.charAt(cPointer)) + skipBy * 10;
                    cPointer++;
                }
                lPointer += skipBy;
                if (lPointer > literal.length()) {
                    return false;
                }
            } else if (compressed.charAt(cPointer) == literal.charAt(lPointer)) {
                lPointer++;
                cPointer++;
            } else {
                return false;
            }
        }

        if (cPointer == compressed.length() && lPointer == literal.length()) {
            return true;
        } else if (cPointer < compressed.length()) {
            while (cPointer < compressed.length()) {
                if (compressed.charAt(cPointer) != '0') {
                    return false;
                }
                cPointer++;
            }
            return true;
        } else {
            return false;
        }
    }
}
