package com.gslonim.coding.strings;

public class Common_Child_of_Two_Strings {
    public static int commonChild(String s1, String s2) {
        String[] rowChars = s2.split("");
        String[] colChars = s1.split("");
        int length = rowChars.length;
        int[][] commonMatrix = new int[length][length];
        int commonCount = 0;

        for (int rowI = 0; rowI < length; rowI++) {
            String rowChar = rowChars[rowI];
            for(int colI = 0; colI < length; colI++) {
                String colChar = colChars[colI];
                int match = match(rowChar, colChar);
                if (rowI == 0 && colI > 0) {
                    commonCount = Math.max(commonMatrix[0][colI - 1], match);
                } else if (rowI > 0 && colI == 0) {
                    commonCount = Math.max(commonMatrix[rowI - 1][0], match);
                } else if (rowI > 0) {
                    if (match == 1) {
                        commonCount = commonMatrix[rowI -1][colI - 1] + match;
                    } else {
                        commonCount = Math.max(commonMatrix[rowI][colI - 1], commonMatrix[rowI - 1][colI]);
                    }
                } else {
                    commonCount = match;
                }
                commonMatrix[rowI][colI] = commonCount;
            }
        }

        return commonCount;
    }

    private static int match(String rowChar, String colChar) {
        return rowChar.equals(colChar) ? 1 : 0;
    }
}
