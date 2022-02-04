package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {
    private NonStart test;

    //Given 2 strings, return their concatenation, except omit the first char of each. The strings will
    //be at least length 1.
    //GetPartialString("Hello", "There") → "ellohere"
    //GetPartialString("java", "code") → "avaode"
    //GetPartialString("shotl", "java") → "hotlava"

    @Before
    public void setup() {
        test = new NonStart();
    }

    @Test
    public void returns_empty_string_when_each_string_is_length_1(){
        String testString1 = "a";
        String testString2 = "b";

        String actual = test.getPartialString(testString1, testString2);

        Assert.assertEquals("", actual);
    }

    @Test
    public void returns_string1_when_each_string2_is_length_1(){
        String testString1 = "apple";
        String testString2 = "b";

        String actual = test.getPartialString(testString1, testString2);

        Assert.assertEquals("pple", actual);
    }

    @Test
    public void returns_string2_when_each_string1_is_length_1(){
        String testString1 = "a";
        String testString2 = "banana";

        String actual = test.getPartialString(testString1, testString2);

        Assert.assertEquals("anana", actual);
    }

    @Test
    public void returns_concatenated_strings_minus_first_char_each(){
        String testString1 = "apple";
        String testString2 = "banana";

        String actual = test.getPartialString(testString1, testString2);

        Assert.assertEquals("ppleanana", actual);
    }
}
