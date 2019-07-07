package com.gslonim.coding.algo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternMatchingTest {

    @Test
    public void should_find_substring() {
        char[] word = new char[] {'i','n','s','t','r','u','c','t','i','o','n','s'};
        char[] pattern = new char[] {'u', 'c', 't'};
        assertThat(PatternMatching.matchesPattern(word, pattern)).isTrue();
    }
}