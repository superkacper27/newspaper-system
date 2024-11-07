package Customer;

import junit.framework.TestCase;

public class CustomerDeleteTest extends TestCase {

    private Customer customer;

    protected void setUp() throws Exception {
        customer = new Customer("Jane", "Doe", "456 Street, City", "0851234567", "D02X285", "Monday, Wednesday, Friday", "jane.doe@example.com");
        customer.setId(1);
    }

    // Test for deleting a customer
    public void testDeleteCustomer() {
        customer.deleteCustomer();
        assertFalse(customer.isActive());
        assertEquals("Customer is inactive", customer.readCustomerInfo());
    }
}
