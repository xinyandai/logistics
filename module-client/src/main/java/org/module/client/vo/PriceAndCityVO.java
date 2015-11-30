package org.module.client.vo;

public class PriceAndCityVO {

	private String distance;
	private String price;
	private String cityA;
	private String cityB;
	
	public PriceAndCityVO(String cityA, String cityB,String distance,String price){
		super();
		this.cityA = cityA;
		this.cityB = cityB;
		this.distance=distance;
		this.price=price;
	}
	
	public String getcityA() {
		return cityA;
	}
	public void setcityA(String cityA) {
		this.cityA = cityA;
	}
	public String getcityB() {
		return cityB;
	}
	public void setcityB(String cityB) {
		this.cityB = cityB;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
