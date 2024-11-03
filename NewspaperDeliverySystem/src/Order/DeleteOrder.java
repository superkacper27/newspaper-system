package Order;

import junit.framework.TestCase;

public class DeleteOrder extends TestCase {
	
	private order order;
	
    protected void setUp() throws Exception {
        order = new order("The Irish Times", "Monday", 0);
    }
    
    public void testDeleteOrder() {
        try {
            order.deleteOrder();  
            
            assertNull("Publication null", order.getPublication());
            assertNull("Days null", order.getDays());   
            
        } catch (OrderExceptionHandler e) {
            fail("Exception not expected during delete");
        }

}
