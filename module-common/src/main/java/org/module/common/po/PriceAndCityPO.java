package org.module.common.po;

public class PriceAndCityPO {
	private String distance;
	private String price;
	public PriceAndCityPO(String distance, String price) {
		super();
		this.distance = distance;
		this.price = price;
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
