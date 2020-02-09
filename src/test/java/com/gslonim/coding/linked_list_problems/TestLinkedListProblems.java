package com.gslonim.coding.linked_list_problems;

import com.gslonim.coding.BaseAlgoTest;
import com.gslonim.utils.ListNode;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLinkedListProblems extends BaseAlgoTest {

    private ListNode listTwo;

    @Test
    public void should_add_two_linked_lists_of_equal_length() {
        whenListOneIs(243);
        whenListTwoIs(564);
        thenExpectedResultIs(708);
    }

    @Test
    public void should_add_two_linked_lists_of_unequal_lentgh() {
        whenListOneIs(0);
        whenListTwoIs(73);
        thenExpectedResultIs(73);

        whenListOneIs("0 0 0 0 0");
        whenListTwoIs("0 1");
        thenExpectedResultIs("0 1 0 0 0");
    }

    private static final class LinkedListProblems {

        static ListNode add_two_numbers_represented_by_linked_lists(ListNode listOne, ListNode listTwo) {
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

    }

    private void thenExpectedResultIs(int expectedResult) {
        assertThat(LinkedListProblems.add_two_numbers_represented_by_linked_lists(listOne, listTwo))
                .isEqualTo(BaseAlgoTest.linkedListFrom(expectedResult));
    }

    private void thenExpectedResultIs(String expectedResult) {
        assertThat(LinkedListProblems.add_two_numbers_represented_by_linked_lists(listOne, listTwo))
                .isEqualTo(BaseAlgoTest.linkedListFrom(expectedResult));
    }

    private void whenListTwoIs(int input) {
        listTwo = BaseAlgoTest.linkedListFrom(input);
    }

    private void whenListTwoIs(String input) {
        listTwo = BaseAlgoTest.linkedListFrom(input);
    }

}
