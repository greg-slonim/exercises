package com.gslonim.coding.pattern_fast_and_slow_pointers;

import com.gslonim.coding.BaseAlgoTest;
import com.gslonim.utils.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFastAndSlowPointerAlgorithm extends BaseAlgoTest {
    @Test
    public void should_detect_cycles_in_linked_list() {
        whenListOneIs(123456);
        whenCycleIsBetween(6, 3);
        then_there_is_a_cycle();

        whenListOneIs(123456789);
        then_there_is_no_cycle();
    }

    @Test
    public void should_find_beginning_of_cycle() {
        whenListOneIs(123456);
        whenCycleIsBetween(6, 3);
        then_cycle_starts_at(3);
    }

    @Test
    public void should_find_middle_node_in_odd_linked_list_length() {
        whenListOneIs(12345);
        then_Middle_Node_Has_Value(3);

        whenListOneIs(123456789);
        then_Middle_Node_Has_Value(5);

        whenListOneIs(123);
        then_Middle_Node_Has_Value(2);

        whenListOneIs(1);
        then_Middle_Node_Has_Value(1);
    }

    @Test
    public void should_find_middle_node_in_even_linked_list_length() {
        whenListOneIs(123456);
        then_Middle_Node_Has_Value(4);

        whenListOneIs(1234);
        then_Middle_Node_Has_Value(3);

        whenListOneIs(12345678);
        then_Middle_Node_Has_Value(5);
    }

    private static class FastAndSlowPointersProblems {

        static boolean linkedListHasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (fast.equals(slow)) {
                    return true;
                }
            }
            return false;
        }

        static ListNode findCycleStart(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            int cycleLength = 0;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    cycleLength = calculateCycleLength(slow);
                    break;
                }
            }

            return findStart(head, cycleLength);
        }

        static ListNode findMiddleOfLinkedList(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private static ListNode findStart(ListNode head, int cycleLength) {
            ListNode pointer1 = head;
            ListNode pointer2 = head;

            while(cycleLength > 0) {
                pointer2 = pointer2.next;
                cycleLength--;
            }

            while (pointer1 != pointer2) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            return pointer1;
        }

        private static int calculateCycleLength(ListNode slow) {
            ListNode current = slow;
            int length = 0;

            do {
                length++;
                current = current.next;
            } while (current != slow);

            return length;
        }

    }

    private void then_Middle_Node_Has_Value(int middleNodeValue) {
        assertThat(FastAndSlowPointersProblems.findMiddleOfLinkedList(listOne).val)
                .isEqualTo(middleNodeValue);
    }

    private void then_cycle_starts_at(int value) {
        assertThat(FastAndSlowPointersProblems.findCycleStart(listOne).val)
                .isEqualTo(value);
    }

    private void then_there_is_a_cycle() {
        assertThat(FastAndSlowPointersProblems.linkedListHasCycle(listOne))
                .isTrue();
    }

    private void then_there_is_no_cycle() {
        assertThat(FastAndSlowPointersProblems.linkedListHasCycle(listOne))
                .isFalse();
    }

    private void whenCycleIsBetween(int from, int to) {
        ListNode head =  listOne;
        ListNode nodeFrom = null, nodeTo = null;
        while(head != null) {
            if (head.val == from) {
                nodeFrom = head;
            }
            if (head.val == to) {
                nodeTo = head;
            }
            head = head.next;
        }
        if (nodeFrom != null && nodeTo != null) {
            nodeFrom.next = nodeTo;
        }
    }
}
