package deliveryDocket;

public class DeliveryDocket {
	
	private int areaNo;
	private String custName;
	private int ID;
	private String Address;
	private String custOrder;
	private String day; 
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	private boolean orderSuccess;

	public int getAreaNo() {
		return areaNo;
	}

	public void setAreaNo(int areaNo) {
		this.areaNo = areaNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getCustOrder() {
		return custOrder;
	}

	public void setCustOrder(String custOrder) {
		this.custOrder = custOrder;
	}

	public boolean isOrderSuccess() {
		return orderSuccess;
	}

	public void setOrderSuccess(boolean orderSuccess) {
		this.orderSuccess = orderSuccess;
	}
	
	public DeliveryDocket(String custName, int areaNo, int iD, String address, String custOrder) throws DeliveryDExceptionHandler {
		validateAreaNo(areaNo);
		this.custName = custName;
		this.areaNo = areaNo;
		this.ID = iD;
		this.Address = address;
		this.custOrder = custOrder;
		this.orderSuccess = true;
		this.day = "Monday";

	}

        
    public void orderDay() {
        if ("Tuesday".equalsIgnoreCase(day)) {
            this.custOrder = "The Irish Independent";
        } else if ("Wednesday".equalsIgnoreCase(day)) {
            this.custOrder = "";
    		}
    	}
    

    public static void validateAreaNo(int areaNo) throws DeliveryDExceptionHandler {
        if (areaNo < 1 || areaNo > 24) {
            throw new DeliveryDExceptionHandler("Invalid Area Number Selected");
        }
    }
    
    public void deliveryStatus() {
        this.orderSuccess = !custOrder.isBlank();
    }
}
