package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    @Test
    public void correct_value_returned_from_three_element_array() {
        //Arrange
        int[] args = new int[] {1, 2, 3}; //init an populate

        //Act
        int actual = ArrayUtils.max(args);

        //Assert
        Assert.assertEquals("Did not return max value.", 3, actual);
    }

    @Test
    public void correct_value_returned_with_repeated_max_vals() {
        //Arrange
        int[] args = new int[] {3, 1, 2, 3}; //init and populate

        //Act
        int actual = ArrayUtils.max(args);

        //Assert
        Assert.assertEquals("Did not return max value.", 3, actual);
    }

    @Test
    public void correct_value_returned_with_all_negative_vals() {
        //Arrange
        int[] args = new int[] {-3, -1, -2, -3}; //init and populate

        //Act
        int actual = ArrayUtils.max(args);

        //Assert
        Assert.assertEquals("Did not return max value.", -1, actual);
    }
}
