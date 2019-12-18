package com.gslonim.coding.strings;

public class Look_and_Say {
    public static int lookAndSay(int max) {
        if (max == 1) {
            return 1;
        }
        if (max == 2) {
            return 11;
        }

        int current = 11;
        for (int i = 2; i < max; i++) {
            current = countNumbers(current);
        }
        return current;
    }

    private static int countNumbers(int current) {
        String currentString = Integer.toString(current);
        int left = 0, right = 0;
        int counter = 0;
        StringBuilder output = new StringBuilder();
        Character l = ' ', r = ' ';
        while(right < currentString.length()) {
            l = currentString.charAt(left);
            r = currentString.charAt(right);
            if (l == r) {
                counter++;
                right++;
            } else {
                output.append(counter).append(l);
                counter = 0;
                left = right;
            }
        }
        output.append(counter).append(r);
        return Integer.parseInt(output.toString());
    }
}
