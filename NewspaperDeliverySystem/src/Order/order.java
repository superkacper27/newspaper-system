package Order;

public class order {

	private String publication;
	private String days;
	
	
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	
	public order(String publication, String days) throws OrderExceptionHandler {
		try {
			validatePublication(publication);
			validateDays(days);
		}catch(OrderExceptionHandler e) {
			throw e;
		}
	}
	

	public static void validatePublication(String publication) throws OrderExceptionHandler {
		if (publication.isBlank() || publication.isEmpty())
			throw new OrderExceptionHandler("Invalid Publication Seleced");
	}
	
	public static void validateDays(String days) throws OrderExceptionHandler {
		if (days.isBlank() || days.isEmpty())
			throw new OrderExceptionHandler("Invalid Day Seleced");
	}
}
