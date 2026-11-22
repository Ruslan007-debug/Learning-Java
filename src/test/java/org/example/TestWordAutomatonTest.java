package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWordAutomatonTest {
    @ParameterizedTest(name = "{index}: [{0}] → {1}")
    @CsvSource({
            "'', S",
            "test, S",
            "T, 1",
            "TE, 2",
            "abcTES, 3",
            "abcTESTabc, F",
            "TX, S",
            "TEX, S",
            "TESX, S",
            "TTEST, F",
            "TETEST, F"
    })
    void recognizesFinalState(String input, String expectedLabel) {
        assertEquals(expectedLabel, TestWordAutomaton.recognize(input).toString());
    }
}
