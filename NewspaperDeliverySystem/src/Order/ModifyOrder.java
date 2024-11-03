package Order;

import junit.framework.TestCase;

public class ModifyOrder extends TestCase {
	
	private order order;
	
	
    protected void setUp() throws Exception {
        order = new order("The Irish Times", "Monday", 0);
    }
    
    // Test modifying the customer name
    public void testModifyOrderPublication() throws OrderExceptionHandler {
        order.setPublication("The Irish Independent");
        assertEquals("The Irish Independent", order.getPublication());
    }

    // Test modifying the customer address
    public void testModifyCustomerAddress() throws OrderExceptionHandler {
        order.setDays("Wednesday");
        assertEquals("Wednesday", order.getDays());
    }

}
