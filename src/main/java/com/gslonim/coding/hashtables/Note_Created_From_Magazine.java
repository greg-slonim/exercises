package com.gslonim.coding.hashtables;

import java.util.HashMap;
import java.util.Map;

public class Note_Created_From_Magazine {
    public static String checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> dictionary = loadDictionary(magazine);

        for (int i = 0; i < note.length; i++) {
            if (!dictionary.containsKey(note[i]) || dictionary.get(note[i]) == 0) {
                return "No";
            }
            dictionary.compute(note[i], (k, v) -> v = v - 1);
        }
        return "Yes";
    }

    private static Map<String, Integer> loadDictionary(String[] magazine) {
        Map<String, Integer> dictionary = new HashMap<>();
        for (String s : magazine) {
            dictionary.merge(s, 1, Integer::sum);
        }
        return dictionary;
    }
}
