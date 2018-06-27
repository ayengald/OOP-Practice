package com.company;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BagTest {

    //ANSWER TO LISKOV QUESTION:
    //I believe that the Bag class is not a legitimate subtype
    //of the LiskovGenericSet because the remove method does not fulfill
    //the property rule.  Thus, the of the substitution principle has been
    //violated.  See my test below of how the remove method has a different
    //effect of the evolution property size().

    Bag<String> b1 = new Bag<String>();
    LiskovGenericSet<String> l1 = new LiskovGenericSet<String>();


    @Rule
    public ExpectedException thrown=ExpectedException.none();


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        b1.insert("cat");
        b1.insert("cat");
        b1.insert("dog");
        b1.insert("rat");
        b1.insert("rat");
        b1.insert("rat");
        l1.insert("cat");
        l1.insert("cat");
        l1.insert("dog");
        l1.insert("rat");
        l1.insert("rat");
        l1.insert("rat");
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void bagsize() throws Exception {

        assertEquals(3, b1.size());

    }

    @Test
    public void liskovsize() throws Exception {

        assertEquals(3, l1.size());

    }
    @Test
    public void baginsert() throws Exception {

        b1.insert("cat");
        assertEquals(3, b1.size());
    }
    @Test
    public void liskovinsert() throws Exception {

        l1.insert("cat");
        assertEquals(3, l1.size());

    }

    @Test
    public void bagremove() throws Exception {

        b1.remove("cat");
        assertEquals(3, b1.size());
        ///*** Note the differing evolution property from the LiskovGenericSet*****\\\\\

    }
    @Test
    public void liskovremove() throws Exception {

        l1.remove("cat");
        assertEquals(2, l1.size());

    }
}