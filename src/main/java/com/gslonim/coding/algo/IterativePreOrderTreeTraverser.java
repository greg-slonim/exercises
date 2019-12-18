package com.gslonim.coding.algo;

import com.gslonim.coding.Harness;
import com.gslonim.utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class IterativePreOrderTreeTraverser implements Harness<Node, List<Integer>> {

    @Override
    public Function<Node, List<Integer>> solution() {
        return IterativePreOrderTreeTraverser::iterateOverTree;
    }

    private static List<Integer> iterateOverTree(Node node) {
        Stack<Node> callStack = new Stack<>();
        List<Integer> nodeValues = new ArrayList<>();
        callStack.push(node);

        while(!callStack.isEmpty()) {
            Node currentNode = callStack.pop();
            nodeValues.add(currentNode.val);
            for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                callStack.add(currentNode.children.get(i));
            }
        }
        return nodeValues;
    }
}
