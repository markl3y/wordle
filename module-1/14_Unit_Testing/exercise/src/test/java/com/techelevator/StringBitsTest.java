package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {
    private StringBits test;

    /*
     * Given a string, return a new string made of every other char starting with
     * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
     * → "H" GetBits("Heeololeo") → "Hello"
     */

    @Before
    public void setup() {
        test = new StringBits();
    }

    @Test
    public void return_empty_string_when_provided_empty_string(){
        String testString = "";

        String actual = test.getBits(testString);

        Assert.assertEquals(testString, actual);
    }

    @Test
    public void return_string_of_first_char_if_provided_string_is_length_2(){
        String testString = "Hi";

        String actual = test.getBits(testString);

        Assert.assertEquals("H", actual);
    }

    @Test
    public void return_string_of_first_char_if_provided_string_is_length_1(){
        String testString = "H";

        String actual = test.getBits(testString);

        Assert.assertEquals("H", actual);
    }

    @Test
    public void return_every_other_char_when_provided_is_even(){
        String testString = "ORANGE";

        String actual = test.getBits(testString);

        Assert.assertEquals("OAG", actual);
    }

    @Test
    public void return_every_other_char_when_provided_is_odd(){
        String testString = "ORANGES";

        String actual = test.getBits(testString);

        Assert.assertEquals("OAGS", actual);
    }

}
