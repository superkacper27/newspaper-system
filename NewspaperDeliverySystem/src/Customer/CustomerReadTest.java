package Customer;

import junit.framework.TestCase;

public class CustomerReadTest extends TestCase {

    private Customer customer;

    protected void setUp() throws Exception {
        // Initialize the customer
        customer = new Customer("Jane", "Doe", "456 Street, City", "0851234567", "D02X285", "Monday, Wednesday, Friday", "jane.doe@example.com");
    }

    // Test for reading customer information
    public void testReadCustomerInfo() {
        // Fetch the auto-generated ID
        int customerId = customer.getId(); // Ensure this ID matches the generated one

        // Expected string based on auto-generated ID
        String expectedInfo = "ID: " + customerId + ", Name: Jane Doe, Address: 456 Street, City, Phone: 0851234567, " +
                              "Email: jane.doe@example.com, Eircode: D02X285, Days of Delivery: Monday, Wednesday, Friday";
        assertEquals(expectedInfo, customer.readCustomerInfo());
    }
}
