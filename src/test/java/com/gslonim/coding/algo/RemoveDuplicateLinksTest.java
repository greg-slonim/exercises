package com.gslonim.coding.algo;

import com.gslonim.utils.ListNode;
import org.junit.Test;

import static com.gslonim.utils.LinkedListUtils.parseAndCreateListOfInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicateLinksTest {
    @Test
    public void should_remove_duplicates_from_sorted_linked_list() {
        ListNode root = parseAndCreateListOfInteger("1 1 1 2");
        ListNode expected = parseAndCreateListOfInteger("1 2");
        ListNode actual = RemoveDuplicateLinks.removeDuplicates(root);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_not_remove_duplicates_in_a_single_node_list() {
        ListNode root = new ListNode(1);
        ListNode actual = RemoveDuplicateLinks.removeDuplicates(root);
        assertThat(actual).isEqualTo(root);
    }

    @Test
    public void should_remove_duplicates_in_the_beginning_and_the_end() {
        ListNode root = parseAndCreateListOfInteger("1 1 1 2 3 3 3");
        ListNode actual = RemoveDuplicateLinks.removeDuplicates(root);
        assertThat(actual).isEqualTo(root);
    }
}
