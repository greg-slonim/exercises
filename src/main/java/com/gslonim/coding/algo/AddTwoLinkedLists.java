package com.gslonim.coding.algo;

import com.gslonim.coding.utils.ListNode;

public class AddTwoLinkedLists {
    public static ListNode addTwoNumbers(ListNode listOne, ListNode listTwo) {

        int listOneLength = getListLength(listOne);
        int listTwoLength = getListLength(listTwo);

        if (listOneLength >= listTwoLength) {
           return sum(listOne, listTwo);

        } else {
            return sum(listTwo, listOne);
        }
    }

    public static ListNode addTwoNumbersSimpler(ListNode listOne, ListNode listTwo) {
        ListNode dummyHead = new ListNode(0);
        ListNode one = listOne;
        ListNode two = listTwo;
        ListNode current = dummyHead;
        int carryOver = 0;

        while(one != null || two != null) {
            int x = (one != null) ? one.val : 0;
            int y = (two != null) ? two.val : 0;

            int sum = x + y + carryOver;
            carryOver = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (one != null) {
                one = one.next;
            }
            if (two != null) {
                two = two.next;
            }
        }
        if (carryOver > 0) {
            current.next = new ListNode(carryOver);
        }
        return dummyHead.next;
    }

    /*
        Even though this works, we should not be changing the output. Use a new list as output
        as it is done in the reference solution above.
     */
    private static ListNode sum(ListNode operandOne, ListNode operandTwo) {
        ListNode sumNode = operandOne;
        int currentValueOne = operandOne.val;
        int currentValueTwo = operandTwo.val;
        int carryOver = 0;

        while (operandOne != null) {
            int sum = currentValueOne + currentValueTwo + carryOver;

            if (sum >= 10) {
                sum = sum - 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
            operandOne.val = sum;
            operandOne = operandOne.next;

            if (operandOne != null) {
                currentValueOne = operandOne.val;
            }

            if (operandTwo.next != null) {
                operandTwo = operandTwo.next;
                currentValueTwo = operandTwo.val;
            } else {
                currentValueTwo = 0;
            }
        }

        ListNode sumPointer = sumNode;
        if (carryOver == 1) {
            while (sumNode.next != null) {
                sumNode = sumNode.next;
            }
            sumNode.next = new ListNode(1);
        }
        return sumPointer;
    }

    private static int getListLength(ListNode listOne) {
        ListNode tempNode = listOne;
        int length = 0;
        while (tempNode != null) {
            tempNode = tempNode.next;
            length++;
        }
        return length;
    }
}
