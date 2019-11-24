package com.gslonim.coding.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StdIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxEntries = scanner.nextInt();
        int numEntries = 0;
        System.out.println("Max iterations: " + maxEntries);

        while (numEntries < maxEntries && scanner.hasNextLine()) {
            System.out.println("numEntries: " + numEntries);
            List<String> tokens = new ArrayList<>();
            Scanner lineScanner = new Scanner(scanner.nextLine());

            while (lineScanner.hasNext()) {
                tokens.add(lineScanner.next());
            }
            lineScanner.close();
            if (!tokens.isEmpty()) {
                System.out.println(tokens);
                numEntries++;
            }
        }
    }
}
