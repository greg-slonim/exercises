package com.gslonim.algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddLinkedListNumbers {

    public static void main(String[] args) {

        AddLinkedListNumbers problem = new AddLinkedListNumbers();
        LinkedList<Integer> left = new LinkedList<>(Arrays.asList(2, 4, 3));
        LinkedList<Integer> right = new LinkedList<>(Arrays.asList(5, 6, 4));

        System.out.println(problem.solution(left, right));

        System.out.println("HELLO".substring(0,1));
    }

    public List solution (LinkedList left, LinkedList right) {
        return null;
    }
}
