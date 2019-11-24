package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;

import java.util.function.Function;

public class CountColumnsToDeleteForNonDecreasingLetters implements Harness<String[], Integer> {

    @Override
    public Function<String[], Integer> solution() {
        return strings -> {
            int deleteIndexLength = 0;

            for (int i = 0; i < strings[0].length(); ++i) {
                for (int j = 0; j < strings.length - 1; ++j) {
                    Character currentLetter = strings[j].charAt(i);
                    Character nextLetter = strings[j+1].charAt(i);
                    if (nextLetter < currentLetter) {
                        deleteIndexLength++;
                        break;
                    }
                }
            }
            return deleteIndexLength;
        };
    }
}
