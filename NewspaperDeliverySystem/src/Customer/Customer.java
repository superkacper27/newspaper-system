package Customer;

public class Customer {
    
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String eircode;
    private int frequency;
    private String daysOfDelivery;
    private boolean active;

    // Constructor
    public Customer(String custName, String custAddr, String custPhone, String custEmail, String custEircode, int frequency, String daysOfDelivery) throws CustomerExceptionHandler {
        this.id = 0; // Default id for now
        setName(custName);
        setAddress(custAddr);
        setPhoneNumber(custPhone);
        setEmail(custEmail);
        setEircode(custEircode);
        setFrequency(frequency);
        setDaysOfDelivery(daysOfDelivery);
        this.active = true; // Customer is active upon creation
    }

    // Getter methods
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getEircode() { return eircode; }
    public int getFrequency() { return frequency; }
    public String getDaysOfDelivery() { return daysOfDelivery; }
    public boolean isActive() { return active; }

    // Setter methods with validation
    public void setId(int custId) { this.id = custId; }
    public void setName(String custName) throws CustomerExceptionHandler { validateName(custName); this.name = custName; }
    public void setAddress(String custAddr) throws CustomerExceptionHandler { validateAddress(custAddr); this.address = custAddr; }
    public void setPhoneNumber(String custPhone) throws CustomerExceptionHandler { validatePhoneNumber(custPhone); this.phoneNumber = custPhone; }
    public void setEmail(String custEmail) throws CustomerExceptionHandler { validateEmail(custEmail); this.email = custEmail; }
    public void setEircode(String custEircode) throws CustomerExceptionHandler { validateEircode(custEircode); this.eircode = custEircode; }
    public void setFrequency(int frequency) throws CustomerExceptionHandler { validateFrequency(frequency); this.frequency = frequency; }
    public void setDaysOfDelivery(String daysOfDelivery) throws CustomerExceptionHandler { validateDaysOfDelivery(daysOfDelivery); this.daysOfDelivery = daysOfDelivery; }

    // Read function
    public String readCustomerInfo() {
        if (!active) return "Customer is inactive";
        return "ID: " + id + ", Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber +
               ", Email: " + email + ", Eircode: " + eircode + ", Frequency: " + frequency +
               ", Days of Delivery: " + daysOfDelivery;
    }

    // Delete function
    public void deleteCustomer() {
        this.active = false;
    }

    // Validation methods (as before)
    public static void validateName(String custName) throws CustomerExceptionHandler { /* validation logic */ }
    public static void validateAddress(String custAddr) throws CustomerExceptionHandler { /* validation logic */ }
    public static void validatePhoneNumber(String custPhone) throws CustomerExceptionHandler { /* validation logic */ }
    public static void validateEmail(String custEmail) throws CustomerExceptionHandler { /* validation logic */ }
    public static void validateEircode(String custEircode) throws CustomerExceptionHandler { /* validation logic */ }
    public static void validateFrequency(int frequency) throws CustomerExceptionHandler { /* validation logic */ }
    public static void validateDaysOfDelivery(String daysOfDelivery) throws CustomerExceptionHandler { /* validation logic */ }
}
