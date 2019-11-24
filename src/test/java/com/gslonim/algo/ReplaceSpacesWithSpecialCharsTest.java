package com.gslonim.algo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReplaceSpacesWithSpecialCharsTest {

    @Test
    public void should_replace_empty_spaces_with_spechal_characters() {
        String input = "I AM A DOG      ";
        int trueLength = 10;

        assertThat(ReplaceSpacesWithSpecialChars.replaceChars(input, trueLength))
                .isEqualTo("I%20AM%20A%20DOG");
    }

}