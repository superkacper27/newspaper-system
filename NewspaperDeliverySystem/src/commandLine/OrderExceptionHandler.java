package commandLine;

public class OrderExceptionHandler extends Exception {
	String message;
	
	public OrderExceptionHandler(String errMessage){
		message = errMessage;
	}
}

