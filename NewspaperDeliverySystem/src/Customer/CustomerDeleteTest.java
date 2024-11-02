package Customer;

import junit.framework.TestCase;

public class CustomerDeleteTest extends TestCase {

    private Customer customer;

    protected void setUp() throws Exception {
        customer = new Customer("Jane Doe", "456 Street, City", "0851234567", "jane.doe@example.com", "D02X285", 3, "Monday, Wednesday, Friday");
        customer.setId(1);
    }

    // Test for deleting a customer
    public void testDeleteCustomer() {
        customer.deleteCustomer();
        assertFalse(customer.isActive());
        assertEquals("Customer is inactive", customer.readCustomerInfo());
    }
}
