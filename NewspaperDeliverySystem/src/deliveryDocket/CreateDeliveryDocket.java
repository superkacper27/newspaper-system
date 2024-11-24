package deliveryDocket;
import junit.framework.TestCase;


public class CreateDeliveryDocket  extends TestCase {
	    private DeliveryDocket deliveryDocket;

	    protected void setUp() throws Exception {
	        deliveryDocket = new DeliveryDocket("Mary", 4, 101, "Dublin Road", "The Irish Times");
	    }

	    // Test 1: Verify creation of the Delivery Docket
	    // Input: Customer Name, Area Number, ID, Address, Order
	    // Expected Outcome: All fields should be set correctly
	    public void testCreateDeliveryDocket() {
	        assertNotNull("Delivery Docket should be created", deliveryDocket);
	        assertEquals("Mary", deliveryDocket.getCustName());
	        assertEquals(4, deliveryDocket.getAreaNo());
	        assertEquals(101, deliveryDocket.getID());
	        assertEquals("Dublin Road", deliveryDocket.getAddress());
	        assertEquals("The Irish Times", deliveryDocket.getCustOrder());
	        assertTrue("Order should be successful", deliveryDocket.isOrderSuccess());
	    }

	    // Test 2: Verify exception for invalid Area No
	    // Input: Invalid Area No (e.g., 0)
	    // Expected Outcome: Should throw DeliveryDExceptionHandler
	    public void testCreateDeliveryDocketInvalidAreaNo() {
	        try {
	            new DeliveryDocket("John", 0, 102, "Main Street", "The Sun");
	            fail("Expected exception not thrown");
	        } catch (DeliveryDExceptionHandler e) {
	            assertEquals("Invalid Area Number Selected", e.getMessage());
	        }
	    }
	}
