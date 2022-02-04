package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Test {
    private MaxEnd3 test;

    @Before
    public void setup() {
        test = new MaxEnd3();
    }

    @Test
    public void returns_array_of_element_if_same() {
        int[] testArray = {3, 1, 1, 3};
        String result = "3333";
        String actualString = "";

        int[] actual = test.makeArray(testArray);
        for (int i = 0; i < actual.length; i++) {
            actualString += actual[i];
        }

        Assert.assertEquals(result, actualString);
    }

    @Test
    public void returns_array_of_element_if_first_larger() {
        int[] testArray = {7, 8, 9, 2};
        String result = "7777";
        String actualString = "";

        int[] actual = test.makeArray(testArray);
        for (int i = 0; i < actual.length; i++) {
            actualString += actual[i];
        }

        Assert.assertEquals(result, actualString);
    }

    @Test
    public void returns_array_of_element_if_last_larger() {
        int[] testArray = {6, 5, 4, 9};
        String result = "9999";
        String actualString = "";

        int[] actual = test.makeArray(testArray);
        for (int i = 0; i < actual.length; i++) {
            actualString += actual[i];
        }

        Assert.assertEquals(result, actualString);
    }
}
