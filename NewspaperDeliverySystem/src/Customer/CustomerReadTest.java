package Customer;

import junit.framework.TestCase;

public class CustomerReadTest extends TestCase {

    private Customer customer;

    protected void setUp() throws Exception {
        // Update constructor parameters to match the new Customer class
        customer = new Customer("Jane", "Doe", "456 Street, City", "0851234567", "D02X285", "Monday, Wednesday, Friday", "jane.doe@example.com");
        customer.setId(1);
    }

    // Test for reading customer information
    public void testReadCustomerInfo() {
        // Update the expected string to match the updated Customer class properties
        String expectedInfo = "ID: 1, Name: Jane Doe, Address: 456 Street, City, Phone: 0851234567, " +
                              "Email: jane.doe@example.com, Eircode: D02X285, Days of Delivery: Monday, Wednesday, Friday";
        assertEquals(expectedInfo, customer.readCustomerInfo());
    }
}
