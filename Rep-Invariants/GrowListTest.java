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
	    	if (GrowList.CONTRACTFALSE)
	    	{
	    		//Please change CONTRACTFALSE in GrowList.java from false to true in order to test CONTRACT FAIL case.
	    		l1.set(-1,"lion");//CONTRACTFALSE
	    		assertEquals("[lion,abhishek,yashu,bhanu]", l1.toString());
	    	}
	    	else
	    	{
		        l1.set(3,"student4");
		        assertEquals("[abhishek,yashu,bhanu,student4]", l1.toString());	    		
	    	}

	    }
	    
	    @Test
	    public void repOK() throws Exception {
	    	boolean result=true;
	    	l1.set(3,"lion");
	    	if(GrowList.REPIVFALSE)
	    	{
	    		l1.set(-1,"lion");//REPIVFALSE
	    		//Please change REPIVFALSE in GrowList.java from false to true in order to test REPIV FAIL case.
	    		
	    	}
	    	result=l1.repOK();
	    	assertEquals(true, result);
	        
	    }

}
