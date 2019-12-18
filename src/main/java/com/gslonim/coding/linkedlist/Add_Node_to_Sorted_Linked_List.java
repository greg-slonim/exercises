package com.gslonim.coding.linkedlist;

public class Add_Node_to_Sorted_Linked_List {
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        // Empty list
        if (head == null) {
            return new DoublyLinkedListNode(data);
        }
        // At the beginning
        if (data < head.data){
            insertPrevious(head, data);
            return head.prev;
        }
        // In-between or at the end
        DoublyLinkedListNode current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
        insertNext(current, data);
        return head;
    }

    private static void insertPrevious(DoublyLinkedListNode current, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        DoublyLinkedListNode tmp = current.prev;
        if (tmp != null) {
            tmp.next = newNode;
            newNode.prev = tmp;
        }
        newNode.next = current;
        current.prev = newNode;
    }

    public static void insertNext(DoublyLinkedListNode current, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        DoublyLinkedListNode tmp = current.next;
        if (tmp != null) {
            tmp.prev = newNode;
            newNode.next = tmp;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public static class DoublyLinkedListNode {
        int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return Integer.toString(data);
        }
    }
}
