package com.gslonim.algo;

public class ReplaceSpacesWithSpecialChars {
    public static String replaceChars(String input, int trueSize) {

        if (input.indexOf(' ') == -1) {
            return input;
        }

        char[] inputArray = input.toCharArray();

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == ' ') {
                trueSize = moveCharacters(inputArray, i, trueSize);
                if ((i + 2) < inputArray.length) {
                    inputArray[i] = '%';
                    inputArray[i + 1] = '2';
                    inputArray[i + 2] = '0';
                }
            }
        }
        return new String(inputArray);
    }

    private static int moveCharacters(char[] inputArray, int startingIndex, int trueSize) {
        int newSize = trueSize + 2;

        for (int i = startingIndex, index = 0; i < trueSize; i++, index++) {
            inputArray[newSize - 1 - index] = inputArray[trueSize - 1 - index];
        }
        return newSize;
    }
}
