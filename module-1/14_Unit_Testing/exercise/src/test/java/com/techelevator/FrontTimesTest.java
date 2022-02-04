package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {
    private FrontTimes test;

    @Before
    public void setup() {
        test = new FrontTimes();
    }

    @Test
    public void returns_x_copies_when_three_or_greater(){
        String tString = "Gang";
        int numTimes = 5;
        String actual = test.generateString(tString, numTimes);
        Assert.assertEquals("generateString does not return first 3 of String of size larger or equal to 3 in length, n times", "GanGanGanGanGan", actual);
    }

    @Test
    public void returns_x_copies_when_two_or_less(){
        String tString = "So";
        int numTimes = 4;
        String actual = test.generateString(tString, numTimes);
        Assert.assertEquals("generateString does not return first String of size smaller or equal to 2 in length, n times", "SoSoSoSo", actual);
    }

    @Test
    public void returns_empty_string_when_n_is_0 (){
        String tString = "Forfeit";
        int numTimes = 0;
        String actual = test.generateString(tString, numTimes);
        Assert.assertEquals("generateString does not return empty String when n is 0 or less", "", actual);
    }

    @Test
    public void returns_empty_string_when_string_is_empty(){
        String tString = "";
        int numTimes = 4;
        String actual = test.generateString(tString, numTimes);
        Assert.assertEquals("generateString does not return empty String when provided String is empty", "", actual);
    }
}
