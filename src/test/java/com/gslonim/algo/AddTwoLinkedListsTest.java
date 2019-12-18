package com.gslonim.algo;

import com.gslonim.coding.linkedlist.AddTwoLinkedLists;
import com.gslonim.utils.ListNode;
import org.junit.Test;

import static com.gslonim.utils.LinkedListUtils.parseAndCreateListOfInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class AddTwoLinkedListsTest {

    @Test
    public void should_add_two_linked_lists_of_equal_length() {
        ListNode listOne = parseAndCreateListOfInteger("2 4 3");
        ListNode listTwo = parseAndCreateListOfInteger("5 6 4");

        ListNode expected = parseAndCreateListOfInteger("7 0 8");
        assertThat(AddTwoLinkedLists.addTwoNumbers(listOne, listTwo)).isEqualTo(expected);

        listOne = parseAndCreateListOfInteger("2 4 3");
        listTwo = parseAndCreateListOfInteger("5 6 4");
        assertThat(AddTwoLinkedLists.addTwoNumbersSimpler(listOne, listTwo)).isEqualTo(expected);
    }

    @Test
    public void should_add_two_linked_lists_of_unequal_lentgh() {
        ListNode listOne = parseAndCreateListOfInteger("0");
        ListNode listTwo = parseAndCreateListOfInteger("7 3");

        ListNode expected = parseAndCreateListOfInteger("7 3");
        assertThat(AddTwoLinkedLists.addTwoNumbers(listOne, listTwo)).isEqualTo(expected);

        listOne = parseAndCreateListOfInteger("0");
        listTwo = parseAndCreateListOfInteger("7 3");
        assertThat(AddTwoLinkedLists.addTwoNumbersSimpler(listOne, listTwo)).isEqualTo(expected);

        listOne = parseAndCreateListOfInteger("0 0 0 0 0");
        listTwo = parseAndCreateListOfInteger("0 1");
        expected = parseAndCreateListOfInteger("0 1 0 0 0");
        assertThat(AddTwoLinkedLists.addTwoNumbers(listOne, listTwo)).isEqualTo(expected);

        listOne = parseAndCreateListOfInteger("0 0 0 0 0");
        listTwo = parseAndCreateListOfInteger("0 1");
        assertThat(AddTwoLinkedLists.addTwoNumbersSimpler(listOne, listTwo)).isEqualTo(expected);
    }

    @Test
    public void should_add_two_linked_lists_with_extra_significant_number() {
        ListNode listOne = parseAndCreateListOfInteger("5");
        ListNode listTwo = parseAndCreateListOfInteger("5");

        ListNode expected = parseAndCreateListOfInteger("0 1");
        assertThat(AddTwoLinkedLists.addTwoNumbers(listOne, listTwo)).isEqualTo(expected);

       listOne = parseAndCreateListOfInteger("5");
       listTwo = parseAndCreateListOfInteger("5");
        assertThat(AddTwoLinkedLists.addTwoNumbersSimpler(listOne, listTwo)).isEqualTo(expected);
    }
}