import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GrowListTest {

	  GrowList<String> l1 = new GrowList<String>();

	  
	  	@Rule
	  	public ExpectedException thrown=ExpectedException.none();
	  	
	    @Before
	    public void setUp() throws Exception {
	        l1.add("abhishek");
	        l1.add("yashu");
	        l1.add("bhanu");
	        l1.add("None");
	    }

	    @After
	    public void tearDown() throws Exception {
	    }

	    @Test
	    public void add() throws Exception {
	        l1.add( "member4");
	        l1.add( "");
	        l1.add( "-3");
	        
	        assertEquals("[abhishek,yashu,bhanu,None,member4,,-3]", l1.toString());
	    }

	    @Test
	    public void size() throws Exception {
	        assertEquals(4, l1.size());
	        l1.add( "member4");
	        assertEquals(5, l1.size());
	    }

	    @Test
	    public void get() throws Exception {
	    	l1.set( 3,"student4"); 
	    	assertEquals("student4", l1.get(3));
	    }

	    @Test
	    public void set() throws Exception {

		        l1.set(3,"student4");
		        assertEquals("[abhishek,yashu,bhanu,student4]", l1.toString());	    		

	    }
	    /*
	    @Test
	    public void testRemove() throws UnsupportedOperationException {
	    	
	    	l1.add("cat");
	    	Iterator g = l1.valuesIt();
	    	assertTrue(g.hasNext()); 
	    	g.remove();
	    	thrown.expectMessage("GrowList.valuesIt");
	    	
	    }*/
	    
	    
	    @Test
	    public void main() throws Exception {
	    	// GrowList<String> list = new GrowList<String>();
	    	 Iterator g = l1.valuesIt();

	    	 assertTrue(g.hasNext()); 
	    	 assertEquals("abhishek", g.next());
	    	 assertTrue(g.hasNext());  
	    	 assertEquals("yashu", g.next());
	    	 assertTrue(g.hasNext()); 
	    	 assertEquals("bhanu", g.next());
	    	 assertTrue(g.hasNext()); 
	    	 assertEquals("None", g.next());
	    	 l1.add("cat");
	    	 assertTrue(g.hasNext()); 
	    	 assertEquals("cat", g.next());

	        thrown.expect(UnsupportedOperationException.class);
	        g.remove();

	    }




	   

}
