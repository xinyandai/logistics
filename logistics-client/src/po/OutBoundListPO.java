package po;

public class OutBoundListPO {

	private String Courier;
	private String date;
	private String destination;
	private String car;
	private String tansportListId;
	private String carId;
	public OutBoundListPO(String courier, String date, String destination,
			String car, String tansportListId, String carId) {
		super();
		Courier = courier;
		this.date = date;
		this.destination = destination;
		this.car = car;
		this.tansportListId = tansportListId;
		this.carId = carId;
	}
	public String getCourier() {
		return Courier;
	}
	public void setCourier(String courier) {
		Courier = courier;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getTansportListId() {
		return tansportListId;
	}
	public void setTansportListId(String tansportListId) {
		this.tansportListId = tansportListId;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}

}
