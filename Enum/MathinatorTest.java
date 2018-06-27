package com.assignment12;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class MathinatorTest {

    private List<Integer> list;
    private Mathinator m = new Mathinator();

    // Set up - Called before every test method.
    @Before
    public void setUp()
    {
        list = new ArrayList<Integer>();
    }


    @Test
    public void addInts() throws Exception {
        assertTrue("addInts result is incorrect", 7 == m.addInts(3,4));
    }

    @Test (expected = NullPointerException.class)
    public void testAddIntsNullValue()
    {
        m.addInts(null, 4);
    }

    @Test
    public void subInts() throws Exception {
        assertTrue("subInts result is incorrect", 3 == m.subInts(5,2));
    }

    @Test (expected = NullPointerException.class)
    public void testSubIntsNullValue()
    {
        m.subInts(3, null);
    }

    @Test
    public void testSingleElement()
    {
        list.add (31);
        Integer i = m.getMax (list);
        assertTrue ("Single Integer List Problem", i == 31);
    }

    @Test
    public void testDoubleElement()
    {
        list.add (73);
        list.add (25);
        Integer i = m.getMax (list);
        assertTrue ("Double Integer List Problem", i == 73);
    }

    //Empty List Test
    @Test (expected = IllegalArgumentException.class)
    public void testEmptyList()
    {
        m.getMax (list);
    }

    @Test (expected = NullPointerException.class)
    public void testForNullElement()
    {
        list.add(1);
        list.add(null);
        list.add(3);
        m.getMax(list);
    }

    @Test (expected = NullPointerException.class)
    public void testForNullList()
    {
        list = null;
        m.getMax(list);
    }

}