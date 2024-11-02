package Customer;

import junit.framework.TestCase;

public class CustomerReadTest extends TestCase {

    private Customer customer;

    protected void setUp() throws Exception {
        customer = new Customer("Jane Doe", "456 Street, City", "0851234567", "jane.doe@example.com", "D02X285", 3, "Monday, Wednesday, Friday");
        customer.setId(1);
    }

    // Test for reading customer information
    public void testReadCustomerInfo() {
        String expectedInfo = "ID: 1, Name: Jane Doe, Address: 456 Street, City, Phone: 0851234567, " +
                              "Email: jane.doe@example.com, Eircode: D02X285, Frequency: 3, Days of Delivery: Monday, Wednesday, Friday";
        assertEquals(expectedInfo, customer.readCustomerInfo());
    }
}

