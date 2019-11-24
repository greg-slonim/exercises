package com.gslonim.algo;

import com.gslonim.utils.ListNode;

public class RemoveDuplicateLinks {
    public static ListNode removeDuplicates(ListNode inputRootNode) {

        if (inputRootNode == null) {
            return inputRootNode;
        }
        ListNode currentNode = inputRootNode;
        ListNode nextNode = inputRootNode.next;
        int currentValue = currentNode.val;

        while(nextNode != null) {
            if (currentValue == nextNode.val) {
                currentNode.next = nextNode.next;
            } else {
                currentNode = nextNode;
                currentValue = nextNode.val;
            }
            nextNode = nextNode.next;
        }

        return inputRootNode;
    }
}