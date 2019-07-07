package com.gslonim.coding.algo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SockMatcherTest {
    @Test
    public void should_find_matching_socks() {
        int answer = SockMatcher.sockMerchant(9, new int [] {10, 20, 20, 10, 10, 30, 50, 10, 20});
        assertThat(answer).isEqualTo(3);
        answer = SockMatcher.sockMerchant(9, new int [] {1, 1, 3, 1, 2, 1, 3, 3, 3, 3 });
        assertThat(answer).isEqualTo(4);
        answer = SockMatcher.sockMerchant(11, new int [] {1, 1, 6, 1, 2, 1, 6, 3, 3, 3, 7});
        assertThat(answer).isEqualTo(4);
    }
}