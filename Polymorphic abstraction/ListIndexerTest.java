package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListIndexerTest {

    List<Integer> intList;
    ListIndexer listIndexInt;

    List<String> stringList;
    ListIndexer listIndexerString;

    List<Character> chartList;
    ListIndexer listIndexerChar;

    @Before
    public void setup() throws Exception{
        intList = Arrays.asList(23, 321, 87, 43, 234, 21);
        listIndexInt = new ListIndexer(intList);

        stringList = Arrays.asList("Cat", "Mouse", "Dog", "Fish", "Turtle", "Rat");
        listIndexerString = new ListIndexer(stringList);

        chartList = Arrays.asList('A', 'B', 'C', null, 'E', 'F');
        listIndexerChar = new ListIndexer(chartList);
    }


    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void searchListOfIntegers() throws ClassNotFoundException {
        assertEquals(4, Search.search(listIndexInt, 234));
    }

    @Test
    public void searchListOfStrings() throws ClassNotFoundException {
        assertEquals(2, Search.search(listIndexerString, "Dog"));
    }

    @Test (expected = ClassNotFoundException.class)
    @SuppressWarnings ("unchecked")
    public void searchElementNotFound() throws ClassNotFoundException {
        int elIndex = Search.search(listIndexerString, "Bat");
    }

    @Test (expected = NullPointerException.class)
    @SuppressWarnings ("unchecked")
    public void searchWithNullElement() throws ClassNotFoundException {
        int elIndex = Search.search(listIndexerChar, 'F');
    }

    @Test (expected = NullPointerException.class)
    @SuppressWarnings ("unchecked")
    public void searchNullList() throws ClassNotFoundException {
        listIndexerChar = null;
        int elIndex = Search.search(listIndexerChar, 'F');
    }


}