package org.module.common.po;

public class DepartmentPO {
	private String name;
	private String category;
	private String location;
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	private String identity;
	
	public DepartmentPO(String name, String category, String location, String identity) {
		super();
		this.name = name;
		this.category = category;
		this.location = location;
	}
	public DepartmentPO(String[] s) {
		
		this(s[0],s[1],s[2],s[3]);
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
}
