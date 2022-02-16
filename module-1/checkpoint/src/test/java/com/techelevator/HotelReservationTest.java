package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class HotelReservationTest {

    //Implement unit tests to validate the functionality of:
    //The estimated total calculation
    //The actual total method

    @Test
    public void test_get_estimated_total() {
        HotelReservation hotelReservation = new HotelReservation("Mike", 1);
        BigDecimal expected = new BigDecimal("59.99");

        BigDecimal actual = hotelReservation.getEstimatedTotal();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_set_actual_total() {
        HotelReservation hotelReservation = new HotelReservation("Mike", 1);
        boolean needsCleaning = true;
        boolean usedMinibar = true;
        BigDecimal expected = new BigDecimal("142.96");

        hotelReservation.setActualTotal(needsCleaning, usedMinibar);
        BigDecimal actual = hotelReservation.getActualTotal();

        Assert.assertEquals(expected, actual);
    }

}
