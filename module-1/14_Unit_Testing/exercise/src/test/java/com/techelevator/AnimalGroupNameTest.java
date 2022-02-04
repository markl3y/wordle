package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
    @Test
    public void correct_return_from_getHerd() {
        //Arrange
        AnimalGroupName test = new AnimalGroupName();
        String animalName = "giraffe";

        //Act
        String actual = test.getHerd(animalName);

        //Assert
        Assert.assertEquals("getHerd does not return the correct herd.", "Tower", actual);
    }

    @Test
    public void null_returns_unknown() {
        //Arrange
        AnimalGroupName test = new AnimalGroupName();
        String animalName = "";

        //Act
        String actual = test.getHerd(animalName);

        //Assert
        Assert.assertEquals("getHerd does not return \"unknown\" when animalName is null", "unknown", actual);
    }

    @Test
    public void unknown_animal_returns_unknown() {
        //Arrange
        AnimalGroupName test = new AnimalGroupName();
        String animalName = "walrus";

        //Act
        String actual = test.getHerd(animalName);

        //Assert
        Assert.assertEquals("getHerd does not return \"unknown\" when animalName is not within map", "unknown", actual);
    }

    @Test
    public void any_case_type_returns_correct_herd() {
        //Arrange
        AnimalGroupName test = new AnimalGroupName();
        String animalName = "RhiNO";

        //Act
        String actual = test.getHerd(animalName);

        //Assert
        Assert.assertEquals("getHerd returns \"unknown\", despite map containing animal", "Crash", actual);
    }

    @Test
    public void multiple_animal_does_not_return_herd() {
        //Arrange
        AnimalGroupName test = new AnimalGroupName();
        String animalName = "elephants";

        //Act
        String actual = test.getHerd(animalName);

        //Assert
        Assert.assertEquals("getHerd returns herd when animalName is plural", "unknown", actual);
    }
}
