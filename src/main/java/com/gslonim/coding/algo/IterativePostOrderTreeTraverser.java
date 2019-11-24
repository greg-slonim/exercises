package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;
import com.gslonim.coding.datastructure.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class IterativePostOrderTreeTraverser implements Harness<Node, List<Integer>> {

    @Override
    public Function<Node, List<Integer>> solution() {
        return IterativePostOrderTreeTraverser::iterateOverTree;
    }

    private static List<Integer> iterateOverTree(Node node) {
        Stack<Node> callStack = new Stack<>();
        List<Integer> nodeValues = new LinkedList<>();
        callStack.push(node);

        while(!callStack.isEmpty()) {
            Node currentNode = callStack.pop();
            if (currentNode != null && currentNode.children != null) {
                currentNode.children.forEach(callStack::push);
//                nodeValues.add(currentNode.val);
            }
        }

        return nodeValues;
    }

    public static void main(String[] args) {
        System.out.println(3 % 1);
    }
}
