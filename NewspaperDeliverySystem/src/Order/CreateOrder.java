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

    // Test 2: Invalid Publication selection
    //Inputs: "Da irish tim"
    //Expected Output: "Invalid Order Publication"

	public void testValidatePublication001() {
			
		try {
			order.validatePublication("Da irish tim");
			fail("Exception expected");
		}
		catch (OrderExceptionHandler e) {
			assertEquals("Invalid Order Publication", e.getMessage());	
		}
	}
	
    // Test 3: Invalid day selection
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
}
