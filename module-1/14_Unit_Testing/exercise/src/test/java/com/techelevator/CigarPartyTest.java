package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {
    private CigarParty test;

    @Before
    public void setup() {
        test = new CigarParty();
    }

    @Test
    public void squirrel_party_successful_on_weekday(){
        //Arrange
        int cigars = 41;
        boolean isWeekend = false;

        //Act
        boolean actual = test.haveParty(cigars, isWeekend);

        //Assert
        Assert.assertEquals("haveParty returns unsuccessful when cigars are in range and its not weekend", true, actual);
    }

    @Test
    public void squirrel_party_unsuccessful_on_weekday(){
        //Arrange
        int cigars = 61;
        boolean isWeekend = false;

        //Act
        boolean actual = test.haveParty(cigars, isWeekend);

        //Assert
        Assert.assertEquals("haveParty returns successful when cigars are not in range and its not weekend", false, actual);
    }

    @Test
    public void squirrel_party_successful_on_weekend(){
        //Arrange
        int cigars = 700;
        boolean isWeekend = true;

        //Act
        boolean actual = test.haveParty(cigars, isWeekend);

        //Assert
        Assert.assertEquals("haveParty returns unsuccessful when cigars are in range and its weekend", true, actual);
    }

    @Test
    public void squirrel_party_unsuccessful_on_weekend(){
        //Arrange
        int cigars = 39;
        boolean isWeekend = true;

        //Act
        boolean actual = test.haveParty(cigars, isWeekend);

        //Assert
        Assert.assertEquals("haveParty returns successful when cigars are not in range and its weekend", false, actual);
    }

}
