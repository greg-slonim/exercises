package com.gslonim.coding.ididnotdoit;

public class BinaryTree {

    private final Node node;

    public BinaryTree(Node root) {
        this.node = root;
    }

    public void printDepthFirst() {
        print(node);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.println(node.value);
        print(node.right);
    }

    public int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + node.value + sum(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node eigth = new Node(8);
        Node five = new Node(5);
        Node six = new Node(6);
        Node eleven = new Node(11);
        Node nine = new Node(9);

        eleven.addLeft(nine);
        eigth.addLeft(five);
        eigth.addRight(six);
        root.addLeft(eigth);
        root.addRight(eleven);

        BinaryTree tree = new BinaryTree(root);
        System.out.println("Total sum is "+ tree.sum(root));
    }

    static class Node {
        private final int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }
        public void addLeft(Node value) {
            this.left = value;
        }
        public void addRight(Node value) {
            this.right = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
