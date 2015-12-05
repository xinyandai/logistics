package org.module.client.vo;

public class DepartmentVO  extends AbstractVO{

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
	public String[] toArray() {
		String[] re = new String[4];
		re[0] = this.name ;
		re[1] = this.category;
		re[2] = this.location ;
		re[3] = this.identity ;
		return re;
	}

	@Override
	public String get(int i) {
		
		return this.toArray()[i];
	}

	@Override
	public String[] names() {

		String[] s = {
				"名称",
				"类别",
				"地址",
				"ID"
		};
	    return s;
	}
	

}
