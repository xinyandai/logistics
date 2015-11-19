package org.module.common.po;

public class TranCenterLoadingListPO {
	private String LoadingDate;
	private String transportListId;
	private String arrival;
	private String carId;
	private String Supervision;
	private String escort;
	private String[] shippingId;
	private String price;
	private State state;
	public TranCenterLoadingListPO(String loadingDate, String transportListId,
			String arrival, String carId, String supervision, String escort,
			String[] shippingId, String price, String state) {
		super();
		LoadingDate = loadingDate;
		this.transportListId = transportListId;
		this.arrival = arrival;
		this.carId = carId;
		Supervision = supervision;
		this.escort = escort;
		this.shippingId = shippingId;
		this.price = price;
		this.state = State.getInstance(state);
	}
	public String getLoadingDate() {
		return LoadingDate;
	}
	public String getTransportListId() {
		return transportListId;
	}
	public String getArrival() {
		return arrival;
	}
	public String getCarId() {
		return carId;
	}
	public String getSupervision() {
		return Supervision;
	}
	public String getEscort() {
		return escort;
	}
	public String[] getShippingId() {
		return shippingId;
	}
	public String getPrice() {
		return price;
	}
	public State getState() {
		return state;
	}
	
	

}
