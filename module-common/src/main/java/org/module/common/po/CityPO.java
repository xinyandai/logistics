package org.module.common.po;

import java.io.Serializable;

public class CityPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6875467710816720203L;
	private String name;
	private String id;
	private String split=":%:%:";
	
	@Override
	public String toString(){
		return this.name+this.split+this.id;
	}
	public CityPO(String str){
		super();
		String[] strs=str.split(this.split);
		this.name=strs[0];
		this.id=strs[1];
	}
	public CityPO(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
		
}
