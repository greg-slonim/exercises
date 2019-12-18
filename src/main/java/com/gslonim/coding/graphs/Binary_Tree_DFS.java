package com.gslonim.coding.graphs;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_DFS {
    public static void traverse_DFS (TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        traverse_DFS(node.left);
        traverse_DFS(node.right);
    }

    public static int findSumOfPathNumbers(TreeNode root) {
        return convert_paths_to_numbers(root, 0);
    }

    private static int convert_paths_to_numbers(TreeNode root, int pathSum) {
        if (root == null) {
            return 0;
        }
        pathSum = pathSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return pathSum;
        }

        return convert_paths_to_numbers(root.left, pathSum) + convert_paths_to_numbers(root.right, pathSum);
    }

    public static boolean has_path(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return targetSum == node.val;
        }
        int reducedSum = targetSum - node.val;
        return has_path(node.left, reducedSum) || has_path(node.right, reducedSum);
    }

    public static List<List<Integer>> find_all_paths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        doFindPaths(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private static void doFindPaths(TreeNode root, int sum, List<Integer> runningPath, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        runningPath.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            allPaths.add(new ArrayList<>(runningPath));
        }
        doFindPaths(root.left, sum - root.val, runningPath, allPaths);
        doFindPaths(root.right, sum - root.val, runningPath, allPaths);

        runningPath.remove(runningPath.size() - 1);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
