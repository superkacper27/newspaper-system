package Order;

import junit.framework.TestCase;

public class DeleteOrder extends TestCase {
	
	private order order;
	
    protected void setUp() throws Exception {
        order = new order("The Irish Times", "Monday", 0);
    }
    
    //Test 1: Delete Order
    //Input: "Delete Order"
    //Expected Outputs: "Order has been deleted
    public void testDeleteOrder() {
        order.deleteOrder();  
		
        assertFalse("Order should be inactive after deletion", order.isActive());
        assertEquals("Order has been deleted", order.readOrder());
    }
}
