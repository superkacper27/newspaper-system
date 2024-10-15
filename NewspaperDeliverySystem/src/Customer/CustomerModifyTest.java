package Customer;

import junit.framework.TestCase;

public class CustomerModifyTest extends TestCase {

    private Customer customer;

    // Setup for tests
    protected void setUp() throws Exception {
        customer = new Customer("John Smith", "123 Street Name, City", "0851234567", "customer@example.com", "D02X285", 3, "Monday, Wednesday, Friday");
    }

    // Test modifying the customer name
    public void testModifyCustomerName() throws CustomerExceptionHandler {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());
    }

    // Test modifying the customer address
    public void testModifyCustomerAddress() throws CustomerExceptionHandler {
        customer.setAddress("456 Another Street, City");
        assertEquals("456 Another Street, City", customer.getAddress());
    }

    // Test modifying the customer phone number
    public void testModifyCustomerPhoneNumber() throws CustomerExceptionHandler {
        customer.setPhoneNumber("0857654321");
        assertEquals("0857654321", customer.getPhoneNumber());
    }

    // Test modifying delivery preferences
    public void testModifyDeliveryPreferences() throws CustomerExceptionHandler {
        customer.setDaysOfDelivery("Tuesday, Thursday");
        assertEquals("Tuesday, Thursday", customer.getDaysOfDelivery());
    }
}
