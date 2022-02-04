package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {
    private DateFashion test;

    @Before
    public void setup(){
        test = new DateFashion();
    }

    @Test
    public void get_table_when_both_stylish(){
        int you = 10;
        int date = 10;
        int actual = test.getATable(you, date);
        Assert.assertEquals("getATable returns 0 or 1 when both are very stylish", 2, actual);
    }

    @Test
    public void get_table_when_both_not_stylish(){
        int you = 1;
        int date = 1;
        int actual = test.getATable(you, date);
        Assert.assertEquals("getATable returns 2 or 1 when both are not stylish", 0, actual);
    }

    @Test
    public void get_table_when_one_stylish(){
        int you = 9;
        int date = 4;
        int actual = test.getATable(you, date);
        Assert.assertEquals("getATable returns 0 or 1 when one is very stylish", 2, actual);
    }

    @Test
    public void not_get_table_when_one_not_stylish(){
        int you = 10;
        int date = 1;
        int actual = test.getATable(you, date);
        Assert.assertEquals("getATable returns 1 or 2 when one is not stylish", 0, actual);
    }

    @Test
    public void maybe_get_table(){
        int you = 5;
        int date = 5;
        int actual = test.getATable(you, date);
        Assert.assertEquals("getATable returns 0 or 2 when both are mediocre style", 1, actual);
    }


}
