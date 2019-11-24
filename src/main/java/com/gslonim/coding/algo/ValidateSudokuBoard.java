package com.gslonim.coding.algo;

import java.util.HashSet;
import java.util.Set;

public class ValidateSudokuBoard {

    private static final String EMPTY = ".";

    public static boolean validateBoard(String[][] board) {
        int cIndex = 0, rIndex = 0;
        for (; rIndex < board[0].length; rIndex++) {
            Set<String> row = new HashSet<>();
            for (; cIndex < board.length; cIndex++) {
                if (checkForDuplicates(row, board[rIndex][cIndex])) {
                    return false;
                }
            }
        }
        for (cIndex = 0; cIndex < board.length; cIndex++) {
            Set<String> column = new HashSet<>();
            for (rIndex = 0; rIndex < board[0].length; rIndex++) {
                if (checkForDuplicates(column, board[rIndex][cIndex])) {
                    return false;
                }
            }
        }
        return validateSubGrids(board);
    }

    private static boolean validateSubGrids(String[][] board) {
        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    System.out.println("Examining r"+i+" c"+j+" block: " + block);
                }
            }
        }
        return true;

    }

    private static boolean checkForDuplicates(Set<String> row, String entry) {
        if (row.contains(entry)) {
            return true;
        }
        if (!entry.equals(EMPTY)) {
            row.add(entry);
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] board = new String[][] {
                {"9", ".", "3", ".", "5", "1"},
                {"1", "5", "4", ".", "2", "."},
                {"2", ".", "6", ".", ".", "9"},
                {"3", "8", ".", "7", ".", "."},
                {"4", "1", ".", "5", ".", "3"},
                {"2", ".", "6", ".", "1", "4"}
        };
        System.out.println("Board valid? " + ValidateSudokuBoard.validateBoard(board));
    }
}
