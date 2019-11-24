package com.gslonim.datastructure;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomHashTableTest {
    private final CustomHashTable table = new CustomHashTable();

    @Test
    public void should_put_and_get_value() {
        table.put("A", "TEST");
        Optional<String> value = table.get("A");
        assertThat(value, is(Optional.of("TEST")));
    }
}