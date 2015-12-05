package org.module.client.vo;



public class StuffVO extends AbstractVO{

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
		this.slaray = 0.0;
	}
	
	public StuffVO(String name, String age, String category, String identity,
			double slaray) {
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

	

	@Override
	public String get(int i) {
		String[] s = {
		this.name ,
		this.age,
		this.category,
		this.identity ,
		this.slaray+"" };
		return s[i];
	}

	@Override
	public String[] names() {
		String[] s = {
				"姓名","年龄","类型","ID","薪水"
		};
	    return s;
	}

	

}
