package deliveryDocket;

public class DeliveryDExceptionHandler extends Exception {
	String message;
	
	public DeliveryDExceptionHandler(String errMessage){
		message = errMessage;
	}

}
