package com.lawson.testdrivendevelopment.strings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestDecomposeValueEqualSubstrings {

    @Test
    public void isDecomposable_When_00_Expect_True() {
        assertTrue(DecomposeValueEqualSubstrings.isDecomposable("00"));
    }

    @Test
    public void isDecomposable_When_000_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable("000"));
    }

    @Test
    public void isDecomposable_When_00111_Expect_True() {
        assertTrue(DecomposeValueEqualSubstrings.isDecomposable("00111"));
    }

    @Test
    public void isDecomposable_When_001111_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable("001111"));
    }

    @Test
    public void isDecomposable_When_111100_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable("111100"));
    }

    @Test
    public void isDecomposable_When_Empty_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable(""));
    }

    @Test
    public void isDecomposable_When_0011_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable("0011"));
    }

    @Test
    public void isDecomposable_When_0011222_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable("0011222"));
    }

    @Test
    public void isDecomposable_When_000111000_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable("000111000"));
    }

    @Test
    public void isDecomposable_When_011100022233_Expect_False() {
        assertFalse(DecomposeValueEqualSubstrings.isDecomposable("011100022233"));
    }

    @Test
    public void isDecomposable_When_011100022233_Expect_True() {
        assertTrue(DecomposeValueEqualSubstrings.isDecomposable("00011111222"));
    }
}
