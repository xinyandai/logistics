package po;

public class LogisticsPO {

	private String origin;
	private String destination;
	private String location;
	private String orderId;
	public LogisticsPO(String origin, String destination, String location,
			String orderId) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.location = location;
		this.orderId = orderId;
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
