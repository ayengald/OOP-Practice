import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class BoundedQueueTest {

	
	BoundedQueue<Integer> queueInt = new BoundedQueue<>(10);
	
	
  	@Rule
  	public ExpectedException thrown=ExpectedException.none();
  	
  	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

    @Before
    public void setUp() throws Exception {
        for (int i = 0; !queueInt.isFull(); i++) {
            queueInt.put(i);
        }

    }

	@After
	public void tearDown() throws Exception {
	}
	
	
    @Test
    public void OverSize() throws Exception {
        for (int i = 10; !queueInt.isFull(); i++) {
            queueInt.put(i);
            //System.out.println("put: " + i);
        }
        queueInt.put(30);
        queueInt.put(20);
        queueInt.put(50);
        assertEquals(10, queueInt.size); 

    }
    
    
    @Test
    public void EmptyException() throws IllegalStateException {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("BoundedQueue.get");
    	while (!queueInt.isEmpty()) {
            System.out.println("get: " + queueInt.get());
        }
    	queueInt.get();
    }
    
    
    @Test
    public void repOKtest() throws IllegalStateException {
    	thrown.expect(IllegalStateException.class);
        thrown.expectMessage("BoundedQueue()");
        BoundedQueue<Integer> queueInt2 = new BoundedQueue<>(0);

    }
    
    @Test
    public void EmptyCheck() throws IllegalStateException {
    	assertEquals(true, queueInt.isFull());
    	assertEquals(false, queueInt.isEmpty());
    	queueInt.getAll();
    	assertEquals(false, queueInt.isFull());
    	assertEquals(true, queueInt.isEmpty());
        queueInt.put(30);
    	assertEquals(false, queueInt.isFull());
    	assertEquals(false, queueInt.isEmpty());
    }

}
