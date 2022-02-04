package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Test {

    private Less20 test;

    @Before
    public void setup() {
        test = new Less20();
    }

    @Test
    public void returns_true_if_2_less_than_multiple_of_20() {
        int testnum = 38;

        boolean actual = test.isLessThanMultipleOf20(testnum);

        Assert.assertEquals("isLessThanMultipleOf20 returns false using integer two less than multiple of 20.", true, actual);
    }

    @Test
    public void returns_true_if_1_less_than_multiple_of_20() {
        int testnum = 39;

        boolean actual = test.isLessThanMultipleOf20(testnum);

        Assert.assertEquals("isLessThanMultipleOf20 returns false using integer one less than multiple of 20.", true, actual);
    }

    @Test
    public void returns_false_if_not_1_or_2_less_than_multiple_of_20() {
        int testnum = 65;

        boolean actual = test.isLessThanMultipleOf20(testnum);

        Assert.assertEquals("isLessThanMultipleOf20 returns true using integer not one or two less than multiple of 20.", false, actual);
    }
}
