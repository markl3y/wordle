package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    private WordCount test;

    /*
     * Given an array of strings, return a Map<String, Integer> with a key for
     * each different string, with the value the number of times that string appears
     * in the array.
     *
     * ** A CLASSIC **
     *
     * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
     * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
     * getCount([]) → {}
     * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
     *
     */

    @Before
    public void setup() {
        test = new WordCount();
    }

    @Test
    public void returns_empty_map_if_no_elements(){
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        String[] testArray = new String[] {};

        Map<String, Integer> actualMap = test.getCount(testArray);

        Assert.assertEquals(testMap, actualMap);
    }

    @Test
    public void returns_one_entry_map_if_one_element_in_provided_array(){
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("Apple", 1);
        String[] testArray = new String[] {"Apple"};

        Map<String, Integer> actualMap = test.getCount(testArray);

        Assert.assertEquals(testMap, actualMap);
    }

    @Test
    public void returns_correct_map_if_every_element_in_provided_array_is_different(){
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("Apple", 1);
        testMap.put("Banana", 1);
        testMap.put("Grape", 1);

        String[] testArray = new String[] {"Apple", "Banana", "Grape"};

        Map<String, Integer> actualMap = test.getCount(testArray);

        Assert.assertEquals(testMap, actualMap);
    }

    @Test
    public void returns_correct_map_if_two_elements_in_provided_array_are_same(){
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("Apple", 2);
        testMap.put("Banana", 1);
        testMap.put("Grape", 1);

        String[] testArray = new String[] {"Apple", "Apple", "Banana", "Grape"};

        Map<String, Integer> actualMap = test.getCount(testArray);

        Assert.assertEquals(testMap, actualMap);
    }

    @Test
    public void returns_correct_map_if_two_elements_in_provided_array_are_same_regardless_of_location(){
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("Apple", 2);
        testMap.put("Banana", 1);
        testMap.put("Grape", 1);

        String[] testArray = new String[] {"Apple", "Banana", "Grape", "Apple"};

        Map<String, Integer> actualMap = test.getCount(testArray);

        Assert.assertEquals(testMap, actualMap);
    }
}
