package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {
    private Lucky13 test;

    @Before
    public void setup() {
        test = new Lucky13();
    }


    @Test
    public void returns_true_if_does_not_contain_1_or_3() {
        //Arrange
        int[] nums = {2, 5, 8};

        //Act
        boolean actual = test.getLucky(nums);

        //Assert
        Assert.assertEquals("getLucky does not return true when array doesn't not contain 1 or 3", true, actual);
    }

    @Test
    public void returns_false_if_contains_1() {
        //Arrange
        int[] nums = {1, 8, 4, 6};

        //Act
        boolean actual = test.getLucky(nums);

        //Assert
        Assert.assertEquals("getLucky return true despite 1 in array", false, actual);
    }

    @Test
    public void returns_false_if_contains_3() {
        //Arrange
        int[] nums = {3, 8, 4, 6};

        //Act
        boolean actual = test.getLucky(nums);

        //Assert
        Assert.assertEquals("getLucky return true despite 3 in array", false, actual);
    }
}
