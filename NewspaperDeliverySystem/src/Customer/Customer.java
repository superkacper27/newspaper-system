package Customer;

public class Customer {

    private static int nextId = 1; // Auto-incrementing ID
    private int id;
    private String Fname;
    private String Sname;
    private String address;
    private String phoneNumber;
    private String email;
    private String eircode;
    private String daysOfDelivery;
    private boolean isActive; // To track if the customer is active or deleted

    // Constructor
    public Customer(String custFName, String custSName, String custAddr, String custPhone, String custEircode, String daysOfDelivery, String custEmail) throws CustomerExceptionHandler {
        this.id = nextId++;
        setFname(custFName);
        setSname(custSName);
        setAddress(custAddr);
        setPhoneNumber(custPhone);
        setEmail(custEmail);
        setEircode(custEircode);
        setDaysOfDelivery(daysOfDelivery);
        this.isActive = true; // Default to active
    }

    // Getter methods
    public String getFname() {
        return Fname;
    }

    public String getSname() {
        return Sname;
    }

    public int getId() {
        return id;
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

    public String getDaysOfDelivery() {
        return daysOfDelivery;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setter methods with validation
    public void setFname(String custFName) throws CustomerExceptionHandler {
        validateFName(custFName);
        Fname = custFName;
    }

    public void setSname(String custSName) throws CustomerExceptionHandler {
        validateSName(custSName);
        Sname = custSName;
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

    public void setDaysOfDelivery(String daysOfDelivery) throws CustomerExceptionHandler {
        validateDaysOfDelivery(daysOfDelivery);
        this.daysOfDelivery = daysOfDelivery;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Validation methods
    public static void validateFName(String custFName) throws CustomerExceptionHandler {
        if (custFName == null || custFName.isEmpty())
            throw new CustomerExceptionHandler("Customer First Name NOT specified");
        else if (custFName.length() < 2)
            throw new CustomerExceptionHandler("Customer First Name does not meet minimum length requirements");
        else if (custFName.length() > 50)
            throw new CustomerExceptionHandler("Customer First Name exceeds maximum length requirements");
        else if (!custFName.matches("^[a-zA-Z ]+$"))
            throw new CustomerExceptionHandler("Customer First Name contains invalid characters");
    }

    public static void validateSName(String custSName) throws CustomerExceptionHandler {
        if (custSName == null || custSName.isEmpty())
            throw new CustomerExceptionHandler("Customer Last Name NOT specified");
        else if (custSName.length() < 2)
            throw new CustomerExceptionHandler("Customer Last Name does not meet minimum length requirements");
        else if (custSName.length() > 50)
            throw new CustomerExceptionHandler("Customer Last Name exceeds maximum length requirements");
        else if (!custSName.matches("^[a-zA-Z ]+$"))
            throw new CustomerExceptionHandler("Customer Last Name contains invalid characters");
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
            throw new CustomerExceptionHandler("Customer Phone Number NOT specified");
        else if (!custPhone.matches("^\\d{7,15}$"))
            throw new CustomerExceptionHandler("Customer Phone Number is invalid");
    }

    public static void validateEmail(String custEmail) throws CustomerExceptionHandler {
        if (custEmail == null || custEmail.isEmpty())
            throw new CustomerExceptionHandler("Customer Email NOT specified");
        else if (!custEmail.matches("^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$"))
            throw new CustomerExceptionHandler("Customer Email is invalid");
    }

    public static void validateEircode(String custEircode) throws CustomerExceptionHandler {
        if (custEircode == null || custEircode.isEmpty())
            throw new CustomerExceptionHandler("Customer Eircode NOT specified");
        else if (!custEircode.matches("^[A-Z0-9]{7}$"))
            throw new CustomerExceptionHandler("Customer Eircode is invalid");
    }

    public static void validateDaysOfDelivery(String daysOfDelivery) throws CustomerExceptionHandler {
        if (daysOfDelivery == null || daysOfDelivery.isEmpty())
            throw new CustomerExceptionHandler("Days of delivery NOT specified");
        else if (!daysOfDelivery.matches("^(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)(,\\s*(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday))*$"))
            throw new CustomerExceptionHandler("Days of delivery contain invalid values");
    }

    // Customer CRUD operations
    public String readCustomerInfo() {
        if (isActive) {
            return "ID: " + id + ", Name: " + Fname + " " + Sname + ", Address: " + address + ", Phone: " + phoneNumber + ", " +
                   "Email: " + email + ", Eircode: " + eircode + ", Days of Delivery: " + daysOfDelivery;
        } else {
            return "Customer is inactive";
        }
    }

    public void deleteCustomer() {
        this.isActive = false;
    }

    public void reactivateCustomer() {
        this.isActive = true;
    }

    @Override
    public String toString() {
        return readCustomerInfo();
    }
}
