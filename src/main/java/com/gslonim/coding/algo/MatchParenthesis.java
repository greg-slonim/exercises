package com.gslonim.coding.algo;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
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

    public static boolean should_match_parens(String s) {
        Map<Character, Character> bracketMatch = setupBrackets();
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character bracket = s.charAt(i);
            System.out.print(bracket);

             if (setupBrackets().containsValue(bracket)) {
                 brackets.push(bracket);
             } else {
                 if (brackets.isEmpty()) {
                     return false;
                 }
                 if (!brackets.peek().equals(bracketMatch.get(bracket))) {
                     return false;
                 }
                 brackets.pop();
             }
        }
        System.out.println();
        return true;
    }

    private static Map<Character, Character> setupBrackets() {
        Map<Character, Character> bracketMatch = new HashMap<>();
        bracketMatch.put(')', '(');
        bracketMatch.put('}', '{');
        bracketMatch.put(']', '[');
        return bracketMatch;
    }
}
