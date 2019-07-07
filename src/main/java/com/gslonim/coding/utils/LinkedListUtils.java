package com.gslonim.coding.utils;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedListUtils {
    public static ListNode parseAndCreateListOfIntegerWithCycles(String input) {
        List<Integer> values = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, ListNode> visited = new HashMap<>();
        List<Integer> uniqueValues = new ArrayList<>();
        ListNode root = new ListNode(values.get(0));
        ListNode first = root;

        for (int index = 1; index < values.size(); index ++) {
            int nodeValue = values.get(index);
            ListNode listNode = new ListNode(nodeValue);
            if (uniqueValues.contains(nodeValue)) {
                root.next = visited.get(uniqueValues.indexOf(nodeValue) + 1);
            } else {
                uniqueValues.add(nodeValue);
                root.next = listNode;
                visited.put(index, listNode);
            }
            root = listNode;
        }
        return first;
    }

    public static ListNode parseAndCreateListOfInteger(String input) {
        List<Integer> values = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ListNode root = new ListNode(values.get(0));
        ListNode first = root;

        for (int index = 1; index < values.size(); index ++) {
            Integer nodeValue = values.get(index);
            ListNode listNode = new ListNode(nodeValue);
            root.next = listNode;
            root = listNode;
        }
        return first;
    }
}
