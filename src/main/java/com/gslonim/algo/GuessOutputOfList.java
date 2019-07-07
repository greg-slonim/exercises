package com.gslonim.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuessOutputOfList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>(3);
        listOfLists.add(0, new ArrayList(Arrays.asList(1, 2, 3, 4)));
        listOfLists.add(1, new ArrayList(Arrays.asList(5, 6, 7, 8)));
        listOfLists.add(2, new ArrayList(Arrays.asList(9, 10, 11, 12)));

        ArrayList<ArrayList<Integer>> tempList = performOps(listOfLists);
        for (int i = 0; i < tempList.size(); i++) {
            for (int j = 0; j < tempList.get(i).size(); j++) {
                System.out.print(tempList.get(i).get(j) + " ");
            }
        }
    }

    static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }
}
