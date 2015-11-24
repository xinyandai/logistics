package org.module.common.po;

public class PriceAndCityPO {
	private String cityA;
	private String cityB;
	private String distance;
	private String price;
	final private String split=":%:%:";
	@Override
	public String toString(){
		return this.cityA+this.split
				+this.cityB+this.split
				+this.distance+this.split+this.price;
	}
	public PriceAndCityPO(String str) {
		super();
		String[] strs=str.split(this.split);
		this.cityA=strs[0];
		this.cityB=strs[1];
		this.distance = strs[2];
		this.price = strs[3];
	}
	public PriceAndCityPO(String cityA,String cityB,String distance, String price) {
		super();
		this.cityA=cityA;
		this.cityB=cityB;
		this.distance = distance;
		this.price = price;
	}
	public String getcityA() {
		return cityA;
	}
	public void cityA(String cityA) {
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
