package org.module.common.po;

import java.io.Serializable;

/**
 * 员工信息
 * 不包括薪水
 * VO中含有薪水（BL层中计算出薪水）
 * @author 
 *
 */
public class StuffPO implements Serializable{
	private String name;
	private String age;
	private String category;
	private String identity;
	
	final private String split=":&:&:";
	
	public StuffPO(String name, String age, String category, String identity) {
		super();
		this.name = name;
		this.age = age;
		this.category = category;
		this.identity = identity;
	}
	
	@Override
	public String toString(){
		return  this.name + this.split + 
				this.age + this.split + 
				this.category + this.split + 
				this.identity;
	}
	
	public StuffPO(String string) {
		String[] s = string.split(split);
		this.name = s[0];
		this.age = s[1];
		this.category = s[2];
		this.identity = s[3];
		
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
