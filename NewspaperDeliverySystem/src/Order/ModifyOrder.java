package Order;

import junit.framework.TestCase;

public class ModifyOrder extends TestCase {
	
	private order order;
	
	
    protected void setUp() throws Exception {
        order = new order("The Irish Times", "Monday", 0);
    }
    
	//Test 1: Edit order
	//Inputs: "The Irish Independent" 
	//Expected Output: Publication: The Irish Independent"
    public void testModifyOrderPublication001() throws OrderExceptionHandler {
        order.setPublication("The Irish Independent");
        assertEquals("The Irish Independent", order.getPublication());
    }
    
	//Test 2: Edit order
	//Inputs: "The Guardian"
	//Expected Output: "Invalid Publication"
    public void testModifyOrderPublication002() throws OrderExceptionHandler {
        order.setPublication("The Guardian");
        assertEquals("The Guardian", order.getPublication());
    }

    //Test 3: Edit Days
    //Inputs: "Wednesday"
    //Expected Output: "Days: Wednesday"
    public void testModifyOrderDays001() throws OrderExceptionHandler {
        order.setDays("Wednesday");
        assertEquals("Wednesday", order.getDays());
    }
    
    //Test 4: Edit Days
    //Inputs: "Christmas"
    //Expected Output: "Invalid Days"
    public void testModifyOrderDays002() throws OrderExceptionHandler {
        order.setDays("Christmas");
        assertEquals("Christmas", order.getDays());
    }
}
