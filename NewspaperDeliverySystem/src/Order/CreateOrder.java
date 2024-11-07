package Order;

import junit.framework.TestCase;
import java.util.*;

public class CreateOrder extends TestCase {

    // Test 1: Validate the list of publications
    //Inputs: Publication = "The Irish Times" Days = "Monday"
    //Expected Output: Customer created with id 0, "Publication: The Irish Times", Days: "Monday"
    
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
    // Test 2: Validate the list of publications
    //Inputs: Publication = "The Sunday Times" Days = "Tuesday"
    //Expected Output: Customer created with id 0, "Publication: The Sunday Times", Days: "Tuesday"
	public void testOrder002() {		
		try {
			
			order ordObj = new order("The Sunday Times", "Tuesday", 0);
			
			assertEquals("The Sunday Times", ordObj.getPublication());
			assertEquals("Tuesday", ordObj.getDays());
		}
		catch (OrderExceptionHandler e) {
			fail("Exception not expected");
		}
	}
    // Test 3: Validate the list of publications
    //Inputs: Publication = "The Irish Independent" Days = "Wednesday"
    //Expected Output: Customer created with id 0, "Publication: The Irish Independent", Days: "Wednesday"
	public void testOrder003() {		
		try {
			
			order ordObj = new order("The Irish Independent", "Wednesday", 0);
			
			assertEquals("The Irish Independent", ordObj.getPublication());
			assertEquals("Wednesday", ordObj.getDays());
		}
		catch (OrderExceptionHandler e) {
			fail("Exception not expected");
		}
	}
    // Test 4: Validate the list of publications
    //Inputs: Publication = "Irish Sun" Days = "Thursday"
    //Expected Output: Customer created with id 0, "Publication: Irish Sun", Days: "Thursday"
	public void testOrder004() {		
		try {
			
			order ordObj = new order("Irish Sun", "Thursday", 0);
			
			assertEquals("Irish Sun", ordObj.getPublication());
			assertEquals("Thursday", ordObj.getDays());
		}
		catch (OrderExceptionHandler e) {
			fail("Exception not expected");
		}
	}
    // Test 5: Validate the list of publications
    //Inputs: Publication = "Irish Daily Mail" Days = "Friday"
    //Expected Output: Customer created with id 0, "Publication: Irish Daily Mail", Days: "Friday"
	public void testOrder005() {		
		try {
			
			order ordObj = new order("Irish Daily Mail", "Friday", 0);
			
			assertEquals("Irish Daily Mail", ordObj.getPublication());
			assertEquals("Friday", ordObj.getDays());
		}
		catch (OrderExceptionHandler e) {
			fail("Exception not expected");
		}
	}
    // Test 6: Validate the list of publications
    //Inputs: Publication = "The Irish Times" Days = "Saturday"
    //Expected Output: Customer created with id 0, "Publication: The Irish Times", Days: "Saturday"
	public void testOrder006() {		
		try {
			
			order ordObj = new order("The Irish Times", "Saturday", 0);
			
			assertEquals("The Irish Times", ordObj.getPublication());
			assertEquals("Saturday", ordObj.getDays());
		}
		catch (OrderExceptionHandler e) {
			fail("Exception not expected");
		}
	}
    // Test 7: Validate the list of publications
    //Inputs: Publication = "The Irish Independent" Days = "Sunday"
    //Expected Output: Customer created with id 0, "Publication: The Irish Independent", Days: "Sunday"
	public void testOrder007() {		
		try {
			
			order ordObj = new order("The Irish Independent", "Sunday", 0);
			
			assertEquals("The Irish Independent", ordObj.getPublication());
			assertEquals("Sunday", ordObj.getDays());
		}
		catch (OrderExceptionHandler e) {
			fail("Exception not expected");
		}
		
	}

    // Test 8: Invalid Publication selection
    //Inputs: "Da irish tim"
    //Expected Output: "Invalid Order Publication"

	public void testValidatePublication001() {
			
		try {
			order.validatePublication("Da ear tim");
			fail("Exception expected");
		}
		catch (OrderExceptionHandler e) {
			assertEquals("Invalid Order Publication", e.getMessage());	
		}
	}
	
    // Test 9: Invalid day selection
    //Inputs: "Monda"
    //Expected Output: "Invalid Order Day"
	
	public void testValidatePublication002() {
		
		try {
			order.validateDays("Monda");
			fail("Exception expected");
		}
		catch (OrderExceptionHandler e) {
			assertEquals("Invalid Order Day", e.getMessage());	
		}
	}
    // Test 10: Blank publication selection
    //Inputs: ""
    //Expected Output: "Exception expected"
	public void testCreateOrderWithEmptyPublication() {
	    try {
	        order ordObj = new order("", "Monday", 1);
			assertEquals("", ordObj.getPublication());
			assertEquals("Monday", ordObj.getDays());

	    } catch (OrderExceptionHandler e) {
			fail("Exception expected");
	    }
	}
    // Test 11: Blank day selection
    //Inputs: ""
    //Expected Output: "Exception expected"

	public void testCreateOrderWithEmptyDays() {
	    try {
	        order ordObj = new order("The Irish Times", "", 1);
			assertEquals("The Irish Times", ordObj.getPublication());
			assertEquals("", ordObj.getDays());


	    } catch (OrderExceptionHandler e) {
			fail("Exception expected");
	    }
	}

}
