package commandLine;


public class CustomerExceptionHandler extends Exception {
    
    public CustomerExceptionHandler(String errMessage) {
        super(errMessage); // Call the superclass constructor with the error message
    }
}
