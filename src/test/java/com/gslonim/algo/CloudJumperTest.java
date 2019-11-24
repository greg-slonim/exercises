package com.gslonim.algo;

import com.gslonim.coding.algo.CloudJumper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CloudJumperTest {
    @Test
    public void shouldCouldShortestPath() {
        assertThat(CloudJumper.jumpingOnClouds(new int[] {0, 0, 1, 0, 0, 1, 0})).isEqualTo(4);
        assertThat(CloudJumper.jumpingOnClouds(new int[] {0, 0, 0, 0, 1, 0})).isEqualTo(3);
        assertThat(CloudJumper.jumpingOnClouds(new int[] {0, 0, 0, 0, 0, 1, 0})).isEqualTo(3);
        assertThat(CloudJumper.jumpingOnClouds(new int[] {0, 0, 0, 0, 0, 1, 0, 1, 0})).isEqualTo(4);
        assertThat(CloudJumper.jumpingOnClouds(new int[] {0, 0, 0, 0, 0})).isEqualTo(2);
        assertThat(CloudJumper.jumpingOnClouds(new int[] {0})).isEqualTo(1);
        assertThat(CloudJumper.jumpingOnClouds(new int[] {0, 1, 0})).isEqualTo(1);
    }
}