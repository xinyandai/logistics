package org.module.client.vo;

import org.module.common.po.State;

public abstract class AbstractLoadingListVO  extends AbstractVO{
	protected String LoadingDate;
	protected String OfficeId;
	protected String trucksId;
	protected String origin;
	protected String target;
	protected String carId;
	protected String Supervision;
	protected String escort;
	/**
	 * 本次装箱所有订单条形码号
	 */
	protected String[] shippingIds;
	protected String price;
	protected State state;
	
	protected String writer;
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
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
		return origin;
	}
	public void setCity(String city) {
		this.origin = city;
	}
	public String getLocation() {
		return target;
	}
	public void setLocation(String location) {
		this.target = location;
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
				,"...",getPrice(),state.toString()};
		return s;
	}
	
	@Override
	public String get(int i) {
		return this.toArray()[i];
	}
}
