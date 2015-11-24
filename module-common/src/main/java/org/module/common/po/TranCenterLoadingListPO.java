package org.module.common.po;

import java.io.Serializable;

public class TranCenterLoadingListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4235679071907414194L;
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
		this.LoadingDate = loadingDate;
		this.transportListId = transportListId;
		this.arrival = arrival;
		this.carId = carId;
		this.Supervision = supervision;
		this.escort = escort;
		this.shippingId = shippingId;
		this.price = price;
		this.state = State.getInstance(state);
	}
	
	public TranCenterLoadingListPO(String string) {
		String[] s = string.split(spt);
		this.transportListId = s[0];
		this.arrival = s[1];
		this.carId = s[2];
		this.Supervision = s[3];
		this.escort = s[4];
		this.shippingId = s[5].split(inlinespt);
		this.price = s[6];
		this.state = State.getInstance(s[7]);
	}

	@Override
	public String toString(){
        return 		this.transportListId + this.spt + 
		this.arrival + this.spt + 
		this.carId + this.spt + 
		this.Supervision + this.spt + 
		this.escort + this.spt + 
		this.getArrayToString( this.shippingId ) + this.spt + 
		this.price + this.spt + 
		this.state.toString();
	}
	/**
	 * 把订单号数组转化为字符串
	 * @param s
	 * @return
	 */
	private String getArrayToString(String[] s){
		String re = "";
		for (String string : s) {
			re += string + this.inlinespt;
		}
		return re;
	}
	final private String spt = ":%:%:";
	final private String inlinespt = "#*#*#";
	
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
