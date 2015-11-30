package org.module.client.vo;

public class CarVO {

	private String id;
	private String License;
	private String time;
	
	
	public CarVO(String id, String license, String time) {
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
	public String[] toArray() {
		String[] re = new String[3];
		re[0] = id;
		re[1] = this.License;
		re[2] = time;
		return re;
	}

}
