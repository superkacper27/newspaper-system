package Order;

public class order {

	private String publication;
	private String days;
	private int ID;
	private boolean active;
	


	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public int getID() {
		return ID;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public order(String publication, String days, int iD) throws OrderExceptionHandler {
		try {
			validatePublication(publication);
			validateDays(days);
			this.ID = 0;
			this.active = true;
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

	public void deleteOrder() {
		this.active = false;
	}
	public String readOrder() {
		if (!active) return "Customer order no longer exists";
        return "Order ID: " + ID + ", Publication: " + publication + ", Days: " + days;
	}
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
}
