package Order;

import junit.framework.TestCase;
import java.util.*;

public class TheOrder extends TestCase {

    // Test 1: Validate the list of publications
    //Inputs: Publication = "The Irish Times" Days = "Monday"
    //Expected Output: Pass
    
	public void testOrder001() {		
		try {
			
			order ordObj = new order("The Irish Times", "Monday", 0);
			
			assertEquals("The Irish Times", ordObj.getPublication());
			assertEquals("Monday", ordObj.getDays());
		}
		catch (OrderExceptionHandler e) {
			fail("Exception not expected");
		}
		
	}

    // Test 2: Invalid Publication selection
    //Inputs: "Da irish tim"
    //Expected Output: Fail

	public void testValidatePublication001() {
			
		try {
				
			//Call method under test
			order.validatePublication("Da irish tim");
			fail("Exception expected");
		}
		catch (OrderExceptionHandler e) {
			assertEquals("Invalid Order Publication", e.getMessage());	
		}
	}
	
    // Test 3: Invalid day selection
    //Inputs: "Monda"
    //Expected Output: Fail
	
	public void testValidatePublication002() {
		
		try {
				
			//Call method under test
			order.validateDays("Monda");
			fail("Exception expected");
		}
		catch (OrderExceptionHandler e) {
			assertEquals("Invalid Order Day", e.getMessage());	
		}
	}
	
	//Test 4: Edit order
	// "The Irish Independent 
	// Expected Output: Pass
	
	public void testEditOrderFields001() {
	    try {
	        // Step 1: Create an order with initial values
	        order ordObj = new order("The Irish Times", "Monday", 0);

	        // Step 2: Edit the publication and days fields
	        ordObj.setPublication("The Irish Independent");
	        ordObj.setDays("Tuesday");

	        // Step 3: Assert that the fields are updated correctly
	        assertEquals("The Irish Independent", ordObj.getPublication());
	        assertEquals("Tuesday", ordObj.getDays());
	    }
	    catch (OrderExceptionHandler e) {
	        fail("Exception not expected during edit");
	    }
	}
	
	//Test 5: Edit order
	//Inputs: "The Guardian"
	// Expected Output: Fail
	
	public void testEditOrderFields002() {
	    try {
	        // Step 1: Create an order with initial values
	        order ordObj = new order("The Irish Times", "Monday", 0);

	        // Step 2: Edit the publication and days fields
	        ordObj.setPublication("The Guardian");
	        ordObj.setDays("Tuesday");

	        // Step 3: Assert that the fields are updated correctly
	        assertEquals("The Guardian", ordObj.getPublication());
	        assertEquals("Tuesday", ordObj.getDays());
	    }
	    catch (OrderExceptionHandler e) {
	        fail("Exception not expected during edit");
	    }
	}


}
