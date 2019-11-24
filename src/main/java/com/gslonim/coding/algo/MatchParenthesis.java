package com.gslonim.coding.algo;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.Stack;

public class MatchParenthesis {
    public static boolean areParenthesisMatched(String expression) {
        Stack<Character> matching = new Stack<>();
        Map<Character, Character> brackets = ImmutableMap.of(
                ')', '(',
                '}', '{',
                ']', '[');

        for (int i = 0; i < expression.length(); i++) {
            char letter = expression.charAt(i);
            if (brackets.containsValue(letter)) {
                matching.push(letter);
            } else if (brackets.containsKey(letter)) {
                if (matching.isEmpty()) {
                    return false;
                }
                Character popped = matching.pop();
                if (!popped.equals(brackets.get(letter))) {
                    return false;
                }
            }
        }

        return matching.isEmpty();
    }
}
