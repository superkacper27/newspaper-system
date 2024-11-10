package commandLine;

public class Order {

	private String publication;
	private String days;
	private int ID;
	private boolean active;
	


	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) throws OrderExceptionHandler {
	    validatePublication(publication); 
		this.publication = publication;
	}
	public int getID() {
		return ID;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) throws OrderExceptionHandler {
	    validateDays(days);

		this.days = days;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public order(String publication, String days, int iD) throws OrderExceptionHandler {
	    validatePublication(publication); 
	    validateDays(days);               
	    this.publication = publication;
	    this.days = days;
	    this.ID = iD;
	    this.active = true;
	}

	
    public boolean isActive() { return active; }

    public static void validatePublication(String publication) throws OrderExceptionHandler {
        if (publication.isBlank() || publication.isEmpty() || 
            !(publication.equals("The Irish Times") ||
              publication.equals("The Irish Independent") ||
              publication.equals("Irish Sun") ||
              publication.equals("The Sunday Times") ||
              publication.equals("Irish Daily Mail"))) 
        {
            throw new OrderExceptionHandler("Invalid Publication Selected");
        }
    }

    public static void validateDays(String days) throws OrderExceptionHandler {
        if (days.isBlank() || days.isEmpty() || 
            !(days.equals("Monday") ||
              days.equals("Tuesday") ||
              days.equals("Wednesday") ||
              days.equals("Thursday") ||
              days.equals("Friday") ||
              days.equals("Saturday") ||
              days.equals("Sunday"))) 
        {
            throw new OrderExceptionHandler("Invalid Day Selected");
        }
    }


	public void deleteOrder() {
		this.active = false;
	}
	public String readOrder() {
		if (!active) return "Order has been deleted";
	    return "Customer ID: " + ID + ", Publication(s): " + publication + ", Day(s) of the Week: " + days;
	}

}


