package com.gslonim.coding.graphs;

import com.gslonim.utils.TreeNode;

import java.util.*;

public class Binary_Tree_BST {
    public List<Integer> average_binary_tree_level(TreeNode<Integer> root) {
        List<Integer> averages = new ArrayList<>();
        if (root == null) {
            return averages;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        /*
            queue: [12], currentNode = 12, levelSum: 12, levelSize: 1, averages: [12]
            queue: [7, 1], currentNode = 7, levelSum: 7, levelSize: 2
            queue: [1, 9], currentNode = 1, levelSum: 8, levelSize: 2, averages: [12, 4]
            queue: [9, 10, 5], currentNode = 9, levelSum: 9, levelSize: 3,
            queue: [10, 5], currentNode = 10, levelSum: 19, levelSize: 3,
            queue: [5], currentNode = 5, levelSum: 24, levelSize: 3, averages: [12, 4, 6]
         */
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> currentNode = queue.poll();
                levelSum += currentNode.value;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            averages.add(levelSum / levelSize);
        }
        return averages;
    }

    /**
     * looking for 10
     * queue: [12], levelSize: 1, currentNode = 12
     * queue: [7, 1], levelSize: 2, currentNode: 7
     * queue: [1, 9], levelSize: 2, currentNode: 1
     * queue: [9, 10, 5], levelSize: 3, currentNode: 9
     * queue: [10, 5], levelSize: 3, currentNode: 10. FOUND.
     */
    public Optional<Integer> find_tree_node_BST(TreeNode<Integer> root, int findValue) {
        if (root == null) {
            return Optional.empty();
        }
        if (root.value == findValue) {
            return Optional.of(findValue);
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> currentNode = queue.poll();
                if (currentNode.value == findValue) {
                    return Optional.of(currentNode.value);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return Optional.empty();
    }

    public static List<List<Integer>> reverse_order_traversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        return result;
    }
}
