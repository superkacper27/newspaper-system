package commandLine;

public class Customer {
    
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String eircode;
    private int frequency;
    private String daysOfDelivery;
    
    // Constructor
    public Customer(String custName, String custAddr, String custPhone, String custEmail, String custEircode, String daysOfDelivery) throws CustomerExceptionHandler {
        this.id = 0; // Default id for now
        setName(custName);
        setAddress(custAddr);
        setPhoneNumber(custPhone);
        setEmail(custEmail);
        setEircode(custEircode);
        setFrequency(frequency);
        setDaysOfDelivery(daysOfDelivery);
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmail() {
        return email;
    }

    public String getEircode() {
        return eircode;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getDaysOfDelivery() {
        return daysOfDelivery;
    }

    // Setter methods with validation
    public void setId(int custId) {
        this.id = custId;
    }

    public void setName(String custName) throws CustomerExceptionHandler {
        validateName(custName);
        this.name = custName;
    }

    public void setAddress(String custAddr) throws CustomerExceptionHandler {
        validateAddress(custAddr);
        this.address = custAddr;
    }

    public void setPhoneNumber(String custPhone) throws CustomerExceptionHandler {
        validatePhoneNumber(custPhone);
        this.phoneNumber = custPhone;
    }

    public void setEmail(String custEmail) throws CustomerExceptionHandler {
        validateEmail(custEmail);
        this.email = custEmail;
    }

    public void setEircode(String custEircode) throws CustomerExceptionHandler {
        validateEircode(custEircode);
        this.eircode = custEircode;
    }

    public void setFrequency(int frequency) throws CustomerExceptionHandler {
        validateFrequency(frequency);
        this.frequency = frequency;
    }

    public void setDaysOfDelivery(String daysOfDelivery) throws CustomerExceptionHandler {
        validateDaysOfDelivery(daysOfDelivery);
        this.daysOfDelivery = daysOfDelivery;
    }

    // Validation methods
    public static void validateName(String custName) throws CustomerExceptionHandler {
        if (custName == null || custName.isEmpty())
            throw new CustomerExceptionHandler("Customer Name NOT specified");
        else if (custName.length() < 2)
            throw new CustomerExceptionHandler("Customer Name does not meet minimum length requirements");
        else if (custName.length() > 50)
            throw new CustomerExceptionHandler("Customer Name exceeds maximum length requirements");
        else if (!custName.matches("^[a-zA-Z ]+$")) // Check for symbols
            throw new CustomerExceptionHandler("Customer Name contains invalid characters");
    }

    public static void validateAddress(String custAddr) throws CustomerExceptionHandler {
        if (custAddr == null || custAddr.isEmpty())
            throw new CustomerExceptionHandler("Customer Address NOT specified");
        else if (custAddr.length() < 5)
            throw new CustomerExceptionHandler("Customer Address does not meet minimum length requirements");
        else if (custAddr.length() > 60)
            throw new CustomerExceptionHandler("Customer Address exceeds maximum length requirements");
    }

    public static void validatePhoneNumber(String custPhone) throws CustomerExceptionHandler {
        if (custPhone == null || custPhone.isEmpty())
            throw new CustomerExceptionHandler("Customer PhoneNumber NOT specified");
        else if (!custPhone.matches("^\\d{7,15}$")) // Ensure the phone number is numeric and within length limits
            throw new CustomerExceptionHandler("Customer PhoneNumber is invalid");
    }

    public static void validateEmail(String custEmail) throws CustomerExceptionHandler {
        if (custEmail == null || custEmail.isEmpty())
            throw new CustomerExceptionHandler("Customer Email NOT specified");
        else if (!custEmail.matches("^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$")) // Basic email pattern validation
            throw new CustomerExceptionHandler("Customer Email is invalid");
    }

    public static void validateEircode(String custEircode) throws CustomerExceptionHandler {
        if (custEircode == null || custEircode.isEmpty())
            throw new CustomerExceptionHandler("Customer Eircode NOT specified");
        else if (!custEircode.matches("^[A-Z0-9]{7}$")) // Ensure Eircode follows a valid pattern
            throw new CustomerExceptionHandler("Customer Eircode is invalid");
    }

    public static void validateFrequency(int frequency) throws CustomerExceptionHandler {
        if (frequency <= 0)
            throw new CustomerExceptionHandler("Frequency must be a positive integer");
    }

    public static void validateDaysOfDelivery(String daysOfDelivery) throws CustomerExceptionHandler {
        if (daysOfDelivery == null || daysOfDelivery.isEmpty())
            throw new CustomerExceptionHandler("Days of delivery NOT specified");
    }
}
