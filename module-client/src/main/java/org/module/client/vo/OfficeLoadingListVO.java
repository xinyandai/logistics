package org.module.client.vo;

import org.module.common.po.State;

/**
 * 快递员揽件之后，营业厅人员负责分拣和装车，并在系统中录入装车单                    
 * 营业厅装车单前缀：       001
 * 装车日期、                 
 * 本营业厅编号（025城市编码+000鼓楼营业厅）、       
 * 汽运编号 （营业厅编号+20150921日期+00000编码 、五位数字）、        
 * 到达地ID（本地中转中心或者其它营业厅）、         
 * 车辆代号、      
 * 监装员、   
 * 押运员、  
 * 本次装箱所有订单条形码号）、   
 * 运费（运费根据出发地和目的地自动生成）
 * @author 
 *
 */

public class OfficeLoadingListVO {

	private String LoadingDate;
	private String OfficeId;
	private String trucksId;
	private String city;
	private String location;
	private String carId;
	private String Supervision;
	private String escort;
	/**
	 * 本次装箱所有订单条形码号
	 */
	private String[] shippingIds;
	private String price;
	private State state;
	
	
	public OfficeLoadingListVO(String loadingDate, String officeId,
			String trucksId, String city,String location, String carId, String supervision,
			String escort, String[] shippingId, String price,String state) {
		super();
		LoadingDate = loadingDate;
		OfficeId = officeId;
		this.trucksId = trucksId;
		this.city = city;
		this.location = location;
		this.carId = carId;
		Supervision = supervision;
		this.escort = escort;
		this.shippingIds = shippingId;
		this.price = price;
		this.setState(State.getInstance(state));
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

}
