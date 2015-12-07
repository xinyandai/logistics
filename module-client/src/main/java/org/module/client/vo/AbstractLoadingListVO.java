package org.module.client.vo;

import org.module.common.po.State;

public abstract class AbstractLoadingListVO  extends AbstractVO{
	protected String LoadingDate;
	protected String OfficeId;
	protected String trucksId;
	protected String city;
	protected String location;
	protected String carId;
	protected String Supervision;
	protected String escort;
	/**
	 * 本次装箱所有订单条形码号
	 */
	protected String[] shippingIds;
	protected String price;
	protected State state;
	
	
	
	public String getLoadingDate() {
		return LoadingDate;
	}
	public void setLoadingDate(String loadingDate) {
		LoadingDate = loadingDate;
	}
	public String getOfficeId() {
		return OfficeId;
	}
	public void setOfficeId(String officeId) {
		OfficeId = officeId;
	}
	public String getTrucksId() {
		return trucksId;
	}
	public void setTrucksId(String trucksId) {
		this.trucksId = trucksId;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String[] getShippingIds() {
		return shippingIds;
	}
	public void setShippingIds(String[] shippingIds) {
		this.shippingIds = shippingIds;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getSupervision() {
		return Supervision;
	}
	public void setSupervision(String supervision) {
		Supervision = supervision;
	}
	public String getEscort() {
		return escort;
	}
	public void setEscort(String escort) {
		this.escort = escort;
	}
	public String[] getShippingId() {
		return shippingIds;
	}
	public void setShippingId(String[] shippingId) {
		this.shippingIds = shippingId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public String[] toArray(){
		String[] s = {getLoadingDate(),
				getOfficeId()
				,getTrucksId(),getCity(),getLocation(),getCarId(),getSupervision(),getEscort()
				,"...",getPrice()};
		return s;
	}
	
	@Override
	public String get(int i) {
		return this.toArray()[i];
	}
}
