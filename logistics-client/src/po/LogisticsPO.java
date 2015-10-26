package po;

public class LogisticsPO {

	private String origin;
	private String destination;
	private String location;
	private String orderId;
	private String state;
	public LogisticsPO(String origin, String destination, String location,
			String orderId,String state) {
		super();
		this.state = state;
		this.origin = origin;
		this.destination = destination;
		this.location = location;
		this.orderId = orderId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getEstination() {
		return destination;
	}
	public void setEstination(String destination) {
		this.destination = destination;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	

}
