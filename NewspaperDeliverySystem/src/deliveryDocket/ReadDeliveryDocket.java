package deliveryDocket;

import junit.framework.TestCase;

public class ReadDeliveryDocket extends TestCase {
    private DeliveryDocket deliveryDocket;

    protected void setUp() throws Exception {
        deliveryDocket = new DeliveryDocket("Mary", 4, 101, "Dublin Road", "The Irish Times");
    }

    // Test 1: Verify readDeliveryDocket functionality
    // Input: Customer Name, Area Number, ID, Address, Order
    // Expected Outcome: All fields should be printed as a string
    public void testReadDeliveryDocket() {
        String expectedOutput = "Delivery Docket Details: " +
                "\nCustomer Name: Mary" +
                "\nArea No: 4" +
                "\nID: 101" +
                "\nAddress: Dublin Road" +
                "\nCustomer Order: The Irish Times" +
                "\nDay: Monday" +
                "\nOrder Success: Yes";
        assertEquals(expectedOutput, deliveryDocket.readDeliveryDocket());
    }

    // Test 2: Verify readDeliveryDocket with different day
    // Input: Change day to Tuesday and check if order updates
    // Expected Outcome: Order for Tuesday should be "The Irish Independent"
    public void testReadDeliveryDocketWithUpdatedOrder() {
        deliveryDocket.setDay("Tuesday");
        deliveryDocket.orderDay();
        String expectedOutput = "Delivery Docket Details: " +
                "\nCustomer Name: Mary" +
                "\nArea No: 4" +
                "\nID: 101" +
                "\nAddress: Dublin Road" +
                "\nCustomer Order: The Irish Independent" +
                "\nDay: Tuesday" +
                "\nOrder Success: Yes";
        assertEquals(expectedOutput, deliveryDocket.readDeliveryDocket());
    }
}

