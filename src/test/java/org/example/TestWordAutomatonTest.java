package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWordAutomatonTest {
    @ParameterizedTest(name = "{index}: [{0}] → {1}")
    @CsvSource({
            "'', S", "'   ', S", "abc, S", "E, S", "S, S",
            "T, 1", "TE, 2", "TES, 3", "TEST, F",
            "TT, 1", "TS, S", "TX, S",
            "TET, 1", "TEE, S", "TEX, S",
            "TESE, S", "TESS, S", "TESX, S",
            "abcTESTabc, F", "abcTES, 3", "abcTEST, F",
            "TESTabc, F", "TESTTEST, F", "TESTT, F",
            "TTEST, F", "TETEST, F", "TESXTEST, F",
            "test, S", "TesT, 1", "ТEST, 1", "TE ST, 1",
            "привіт🙂TEST!, F"
    })
    void recognizesFinalState(String input, String expectedLabel) {
        assertEquals(expectedLabel, TestWordAutomaton.recognize(input).toString());
    }
}
