package org.module.common.po;

public class CarPO {

	private String id;
	private String License;
	private String time;
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
