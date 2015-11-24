package org.module.common.po;

import java.io.Serializable;

public class OfficeLoadingListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3372677309273986485L;
	private String LoadingDate;
	private String OfficeId;
	private String trucksId;
	private String arrival;
	private String carId;
	private String Supervision;
	private String escort;
	private String[] shippingId;
	private String price;
	
	
	private State state;

	final private String spt = ":%:%:";
	final private String inlinespt = "#*#*#";

	public OfficeLoadingListPO(String string) {
		String[] s = string.split(spt);
		this.LoadingDate = s[0];
		this.OfficeId = s[1];
		this.trucksId = s[2];
		this.arrival = s[3];
		this.carId = s[4];
		this.Supervision = s[5];
		this.escort= s[6];
		this.shippingId = s[7].split(this.inlinespt);
		this.price = s[8];
		this.state = State.getInstance(s[9]);
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
	@Override
	public String toString(){
		return this.LoadingDate + this.spt +
				this.OfficeId  + this.spt +
				this.trucksId  + this.spt +
				this.arrival  + this.spt +
				this.carId  + this.spt +
				this.Supervision  + this.spt +
				this.escort + this.spt +
				//
				this.getArrayToString(this.shippingId)  + this.spt +
				//
				this.price  + this.spt +
				this.state.toString() ;
	}

	public OfficeLoadingListPO(String loadingDate, String officeId,
			String trucksId, String arrival, String carId, String supervision,
			String escort, String[] shippingId, String price, String state) {
		super();
		this.LoadingDate = loadingDate;
		this.OfficeId = officeId;
		this.trucksId = trucksId;
		this.arrival = arrival;
		this.carId = carId;
		this.Supervision = supervision;
		this.escort = escort;
		this.shippingId = shippingId;
		this.price = price;
		this.state = State.getInstance(state);
	}

	

	/*public OfficeLoadingListPO(String[] a){
	}*/
	public String getLoadingDate() {
		return LoadingDate;
	}


	public String getOfficeId() {
		return OfficeId;
	}


	public String getTrucksId() {
		return trucksId;
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
