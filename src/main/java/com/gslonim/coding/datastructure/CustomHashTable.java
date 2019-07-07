package com.gslonim.coding.datastructure;

import java.util.ArrayList;
import java.util.Optional;

public class CustomHashTable {
    private static final int TABLE_SIZE = 20;
    private final ArrayList<String>[] table = new ArrayList[TABLE_SIZE];

    public void put(String key, String value) {
        int index = getIndex(key);
        table[index] = createEntry(key, value);
    }

    public Optional<String> get(String key) {
        int index = getIndex(key);
        if (table[index] == null) {
            return Optional.empty();
        }
        ArrayList<String> entry = table[index];
        return Optional.ofNullable(entry.get(1));
    }

    private ArrayList<String> createEntry(String key, String value) {
        ArrayList<String> keyValue = new ArrayList<>();
        keyValue.add(key);
        keyValue.add(value);
        return keyValue;
    }

    private static int getIndex(String key) {
        long hashCode = key.hashCode();
        return (int) hashCode % TABLE_SIZE;
    }
}
