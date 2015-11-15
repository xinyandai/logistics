package org.module.client.vo;



public class StuffVO {

	private String name;
	private String age;
	private String category;
	private String identity;
	private double slaray;
	
	public StuffVO(String name, String age, String category, String identity) {
		super();
		this.name = name;
		this.age = age;
		this.category = category;
		this.identity = identity;
	}
	
	public StuffVO(String name, String age, String category, String identity,
			int slaray) {
		super();
		this.name = name;
		this.age = age;
		this.category = category;
		this.identity = identity;
		this.slaray = slaray;
	}
	public  void setSlary(double s){
		this.slaray  =s ;
	}
	public  double getSlary(){
		return this.slaray ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
