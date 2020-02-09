package com.gslonim.coding;

import com.gslonim.utils.ListNode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseAlgoTest {
    protected int[] input;
    protected int sum;
    protected ListNode listOne;

    protected void whenArrayIs(int[] array) {
        input = array;
    }

    protected void whenTargetSumIs(int size) {
        sum = size;
    }

    protected static ListNode linkedListFrom(String stringInput) {
        List<Integer> values = Arrays.stream(stringInput.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return createLinkedList(values);
    }

    protected static ListNode linkedListFrom(int input) {
        List<Integer> values = String
                .valueOf(input)
                .chars()
                .boxed()
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
        return createLinkedList(values);
    }

    @NotNull
    private static ListNode createLinkedList(List<Integer> values) {
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

    protected void whenListOneIs(String input) {
        listOne = BaseAlgoTest.linkedListFrom(input);
    }

    protected void whenListOneIs(int input) {
        listOne = BaseAlgoTest.linkedListFrom(input);
    }
}
