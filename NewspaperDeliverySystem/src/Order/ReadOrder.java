package Order;

import junit.framework.TestCase;

public class ReadOrder extends TestCase {
	
	private order order;
	
	
    protected void setUp() throws Exception {
        order = new order("The Irish Times", "Monday", 0);
    }
        
    
    //Test 1: Read Order
    //Input: Read Order
    //Expected Output: "Publication(s): The Irish Times, Day(s) of the Week: Monday, Customer ID: 0"
        public void testReadOrder() {
        	
        	String expectedInfo = "Customer ID: 0, Publication(s): The Irish Times, Day(s) of the Week: Monday";

            assertEquals(expectedInfo, order.readOrder());
    }

}
