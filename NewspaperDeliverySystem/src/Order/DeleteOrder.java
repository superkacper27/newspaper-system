package Order;

import junit.framework.TestCase;

public class DeleteOrder extends TestCase {
	
	private order order;
	
    protected void setUp() throws Exception {
        order = new order("The Irish Times", "Monday", 0);
    }
    
    //Test 1: Delete Order
    //Input: "Delete Order"
    //Expected Outputs: "Order has been deleted"
    public void testDeleteOrder() {
        order.deleteOrder();  
		
        assertFalse("Order should be inactive after deletion", order.isActive());
        assertEquals("Order has been deleted", order.readOrder());
    }
    //Test 2: Delete Order
    //Input: "Delete Order" a second time
    //Expected Outputs: Order is still inactive
    public void testDoubleDeletion() {
        order.deleteOrder();
        assertFalse(order.isActive());
        order.deleteOrder();  
        assertFalse(order.isActive()); 
    }
    //Test 3: Delete Order
    //Input: "Read Order" after Deletion
    //Expected Outputs: "Customer order no longer exists"

    public void testReadAfterDeletion() {
        order.deleteOrder();
        assertEquals("Customer order no longer exists", order.readOrder());
    }

}
