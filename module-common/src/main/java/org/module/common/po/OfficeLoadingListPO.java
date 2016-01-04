package org.module.common.po;

import java.io.Serializable;

public class OfficeLoadingListPO extends AbstractPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3372677309273986485L;
	private String LoadingDate;
	private String OfficeId;
	private String trucksId;
	private String city;
	private String location;
	private String carId;
	private String Supervision;
	private String escort;
	private String[] shippingId;
	private String price;
	
	
	private State state;

	private String writer;
	final private String spt = ":%:%:";
	final private String inlinespt = "&&&&&&&";

	public OfficeLoadingListPO(String string) {
		String[] s = string.split(spt);
		this.LoadingDate = s[0];
		this.OfficeId = s[1];
		this.trucksId = s[2];
		this.city = s[3];
		this.location = s[4];
		this.carId = s[5];
		this.Supervision = s[6];
		this.escort= s[7];
		this.shippingId = s[8].split(this.inlinespt);
		this.price = s[9];
		this.state = State.getInstance(s[10]);
		this.writer = s[11];
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
				this.city  + this.spt +
				this.location + this.spt + 
				this.carId  + this.spt +
				this.Supervision  + this.spt +
				this.escort + this.spt +
				//
				this.getArrayToString(this.shippingId)  + this.spt +
				//
				this.price  + this.spt +
				this.state.toString() + this.spt + this.writer;
	}

	

	

	public OfficeLoadingListPO(String loadingDate, String officeId,
			String trucksId, String city, String location, String carId,
			String supervision, String escort, String[] shippingId,
			String price, State state , String w) {
		super();
		LoadingDate = loadingDate;
		OfficeId = officeId;
		this.trucksId = trucksId;
		this.city = city;
		this.location = location;
		this.carId = carId;
		Supervision = supervision;
		this.escort = escort;
		this.shippingId = shippingId;
		this.price = price;
		this.state = state;
		this.writer = w;
	}
	@Override
	public String getBelongsToPersonOrDepartment() {
		// TODO Auto-generated method stub
		return this.writer;
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


	

	public String getCity() {
		return city;
	}
	public String getLocation() {
		return location;
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
	
	public String getWriter() {
		return this.writer;
	}
	@Override
	public String getNniqueID() {
		// TODO Auto-generated method stub
		return this.getTrucksId();
	}
}
