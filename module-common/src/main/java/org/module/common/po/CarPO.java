package org.module.common.po;

public class CarPO {

	private String split =":%:%:";
	
	private String id;
	private String License;
	private String time;
	
	@Override
	public String toString(){
		return this.id+this.split
		+this.License+this.split
		+this.time;
	}
	
	public CarPO(String str){
		super();
		String[] strs = str.split(this.split);
		this.id = strs[0];
		this.License = strs[1];
		this.time = strs[2];
	}
	
	public CarPO(String id, String license, String time) {
		super();
		this.id = id;
		License = license;
		this.time = time;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLicense() {
		return License;
	}
	public void setLicense(String license) {
		License = license;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
