package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {
    private SameFirstLast test;

    /*
     Given an array of ints, return true if the array is length 1 or more, and the first element and
     the last element are equal.
     IsItTheSame([1, 2, 3]) → false
     IsItTheSame([1, 2, 3, 1]) → true
     IsItTheSame([1, 2, 1]) → true
     */

    @Before
    public void setup() {
        test = new SameFirstLast();
    }

    @Test
    public void return_false_if_array_empty(){
        int[] testArray = {};

        boolean actual = test.isItTheSame(testArray);

        Assert.assertFalse(actual);
    }

    @Test
    public void return_true_if_array_first_and_last_are_equal(){
        int[] testArray = {1, 2, 3, 1};

        boolean actual = test.isItTheSame(testArray);

        Assert.assertTrue(actual);
    }

    @Test
    public void return_true_if_array_is_size_one(){
        int[] testArray = {1};

        boolean actual = test.isItTheSame(testArray);

        Assert.assertTrue(actual);
    }

    @Test
    public void return_true_if_array_is_size_two_and_values_are_same(){
        int[] testArray = {1, 1};

        boolean actual = test.isItTheSame(testArray);

        Assert.assertTrue(actual);
    }

    @Test
    public void return_false_if_array_is_size_two_and_values_are_different(){
        int[] testArray = {1, 2};

        boolean actual = test.isItTheSame(testArray);

        Assert.assertFalse(actual);
    }
}
