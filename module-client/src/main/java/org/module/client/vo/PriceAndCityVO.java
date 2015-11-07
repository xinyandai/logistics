package org.module.client.vo;

public class PriceAndCityVO {

	private String distance;
	private String price;
	public PriceAndCityVO(String distance, String price) {
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
