package Customer;

import junit.framework.TestCase;

public class CustomerCreateTest extends TestCase {

    // Test valid customer creation with valid inputs
    public void testValidCustomerCreation() throws CustomerExceptionHandler {
        Customer customer = new Customer("John", "Smith", "123 Street Name, City", "0851234567", "D02X285", "Monday, Wednesday", "customer@example.com");
        assertEquals("John", customer.getFname());
        assertEquals("Smith", customer.getSname());
        assertEquals("123 Street Name, City", customer.getAddress());
        assertEquals("0851234567", customer.getPhoneNumber());
    }

    // Test invalid name with special characters
    public void testInvalidCustomerNameWithSymbols() {
        try {
            new Customer("John@Smith", "Smith", "123 Street Name, City", "0851234567", "D02X285", "Monday, Wednesday", "customer@example.com");
            fail("Expected an exception for invalid customer name with symbols.");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer Name contains invalid characters", e.getMessage());
        }
    }

    // Test invalid name with length exceeding maximum
    public void testCustomerNameTooLong() {
        try {
            new Customer("John Smith John Smith John Smith John Smith John Smith", "Smith", "123 Street Name, City", "0851234567", "D02X285", "Monday, Wednesday", "customer@example.com"); // 65 characters
            fail("Expected an exception for customer name exceeding max length.");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer Name exceeds maximum length requirements", e.getMessage());
        }
    }

    // Test valid address
    public void testValidCustomerAddress() throws CustomerExceptionHandler {
        Customer customer = new Customer("John", "Smith", "123 Street Name, City", "0851234567", "D02X285", "Monday, Wednesday", "customer@example.com");
        assertEquals("123 Street Name, City", customer.getAddress());
    }

    // Test valid phone number
    public void testValidPhoneNumber() throws CustomerExceptionHandler {
        Customer customer = new Customer("John", "Smith", "123 Street Name, City", "0851234567", "D02X285", "Monday, Wednesday", "customer@example.com");
        assertEquals("0851234567", customer.getPhoneNumber());
    }

    // Test invalid empty phone number
    public void testInvalidEmptyPhoneNumber() {
        try {
            new Customer("John", "Smith", "123 Street Name, City", "", "D02X285", "Monday, Wednesday", "customer@example.com");
            fail("Expected an exception for empty phone number.");
        } catch (CustomerExceptionHandler e) {
            assertEquals("Customer PhoneNumber NOT specified", e.getMessage());
        }
    }

    // Test valid email
    public void testValidEmail() throws CustomerExceptionHandler {
        String email = "customer@example.com";
        Customer customer = new Customer("John", "Smith", "123 Street Name, City", "0851234567", "D02X285", "Monday, Wednesday", email);
        assertEquals(email, customer.getEmail());
    }

    // Test valid address with country
    public void testValidAddressWithCountry() throws CustomerExceptionHandler {
        Customer customer = new Customer("John", "Smith", "123 Street Name, City, Country", "0851234567", "D02X285", "Monday, Wednesday", "customer@example.com");
        assertEquals("123 Street Name, City, Country", customer.getAddress());
    }

    // Test valid Eircode
    public void testValidEircode() throws CustomerExceptionHandler {
        String eircode = "D02X285";
        Customer customer = new Customer("John", "Smith", "123 Street Name, City", "0851234567", eircode, "Monday, Wednesday", "customer@example.com");
        assertEquals(eircode, customer.getEircode());
    }

    // Test valid frequency and delivery days
    public void testValidFrequencyAndDays() throws CustomerExceptionHandler {
        String daysOfDelivery = "Monday, Wednesday";
        Customer customer = new Customer("John", "Smith", "123 Street Name, City", "0851234567", "D02X285", daysOfDelivery, "customer@example.com");
        assertEquals(daysOfDelivery, customer.getDaysOfDelivery());
    }
}
