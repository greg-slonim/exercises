package com.gslonim.algo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountValleysTest {
    @Test
    public void shouldCountValleys() {
        assertThat(CountValleys.countingValleys(8, "DDUUUUDD")).isEqualTo(1);
        assertThat(CountValleys.countingValleys(10, "UUUUUDDDDD")).isEqualTo(0);
        assertThat(CountValleys.countingValleys(16, "DDUUDDUUDDUUUUDD")).isEqualTo(3);
        assertThat(CountValleys.countingValleys(20, "DDDDDDDDDDUUUUUUUUUU")).isEqualTo(1);
        assertThat(CountValleys.countingValleys(14, "DUDUDUDUDUDUDU")).isEqualTo(7);
        assertThat(CountValleys.countingValleys(0, "")).isEqualTo(0);
        assertThat(CountValleys.countingValleys(2, "DU")).isEqualTo(1);
        assertThat(CountValleys.countingValleys(2, "UD")).isEqualTo(0);
        assertThat(CountValleys.countingValleys(4, "UUDD")).isEqualTo(0);
        assertThat(CountValleys.countingValleys(12, "DDUUUUDDUUDD")).isEqualTo(1);
    }
}