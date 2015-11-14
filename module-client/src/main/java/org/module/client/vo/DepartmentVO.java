package org.module.client.vo;

public class DepartmentVO {

	private String name;
	private String category;
	private String location;
	private String identity;
	
	
	public DepartmentVO(String name, String category, String location,
			String identity) {
		super();
		this.name = name;
		this.category = category;
		this.location = location;
		this.identity = identity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	

}
