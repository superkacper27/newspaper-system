package Delivery_Docket;
import junit.framework.TestCase;

public class ModifyDeliveryDocketTest extends TestCase {
	private DeliveryDocket deliveryDocket;
	
    protected void setUp() throws Exception {
    	deliveryDocket = new DeliveryDocket("Mary", 4, 0, "Dublin Road", "The Irish Times");
    }
    
    //Test 1: Successful Delivery
    //Input: Delivery Success
    //Expected Outcome: orderSuccess is true
    
    public void deliverySuccess001() {
        deliveryDocket.setDay("Monday");
        deliveryDocket.deliveryStatus();
        assertTrue("Successful Delivery", deliveryDocket.isOrderSuccess());
    }

    //Test 2: Unsuccessful Delivery
    //Input: Delivery Unsuccessful
    //Expected Outcome: orderSuccess is false
    public void deliverySuccess002() {
    	deliveryDocket.setDay("Wednesday");
        deliveryDocket.orderDay();
        deliveryDocket.deliveryStatus();
        assertFalse("Unsuccessful Delivery", deliveryDocket.isOrderSuccess());
    }

    
    //Test 3: Order for Tuesday
    //Input: Day = Tuesday
    //Expected Output: Publication = The Irish Independent

    public void testModifyOrderForTuesday() {
        deliveryDocket.setDay("Tuesday");
        deliveryDocket.orderDay();
        assertEquals("The Irish Independent", deliveryDocket.getCustOrder());
    }

    //Test 4: Order for Monday
    //Input: Day = Monday
    //Expected Output: Publication = The Irish Times

    public void testModifyOrderForNonTuesday() {
        deliveryDocket.setDay("Monday");
        deliveryDocket.orderDay();
        assertEquals("The Irish Times", deliveryDocket.getCustOrder());
    }
    
    //Test: Order for Wednesday
    //Input: Day = Wednesday
    //Expected Output: No publication

    public void testNoOrderOnWednesday() {
        deliveryDocket.setDay("Wednesday");
        deliveryDocket.orderDay();
        assertEquals("", deliveryDocket.getCustOrder());
    }
}