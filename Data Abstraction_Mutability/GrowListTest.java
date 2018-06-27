import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrowListTest {

	  GrowList<String> l1 = new GrowList<String>();

	    @Before
	    public void setUp() throws Exception {
	        l1 = l1.add(l1, "abhishek");
	        l1 = l1.add(l1, "yashu");
	        l1 = l1.add(l1, "bhanu");
	    }

	    @After
	    public void tearDown() throws Exception {
	    }

	    @Test
	    public void add() throws Exception {
	        l1 = l1.add(l1, "member4");
	        l1 = l1.add(l1, "");
	        l1 = l1.add(l1, "-3");
	        assertEquals("[abhishek,yashu,bhanu,member4,,-3]", l1.toString());
	    }

	    @Test
	    public void size() throws Exception {
	        assertEquals(3, l1.size());
	        l1 = l1.add(l1, "member4");
	        assertEquals(4, l1.size());
	    }

	    @Test
	    public void get() throws Exception {
	    	l1 = l1.set(l1, 3,"student4"); 
	    	assertEquals("student4", l1.get(3));
	    }

	    @Test
	    public void set() throws Exception {
	        l1 = l1.set(l1, 3,"student4");
	        assertEquals("[abhishek,yashu,bhanu,student4]", l1.toString());
	    }

}
