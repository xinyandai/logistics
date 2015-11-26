package org.module.common.po;

import java.io.Serializable;

public class DriverPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 518479856023930155L;
	private String id;
	private String name;
	private String birthday;
	private String Idcard;
	private String phone;
	private String gender;
	private String date;
	final private String split=":%:%:";
	@Override
	public String toString(){
		return this.id+this.split+this.name+this.split
				+this.birthday+this.split+this.Idcard
				+this.split+this.phone+this.split+this.gender
				+this.split+this.date;
	}
	public DriverPO(String str) {
		super();
		String[] strs=str.split(this.split);
		this.id = strs[0];
		this.name = strs[1];
		this.birthday = strs[2];
		Idcard = strs[3];
		this.phone = strs[4];
		this.gender = strs[5];
		this.date = strs[6];
	}
	public DriverPO(String id, String name, String birthday, String idcard,
			String phone, String gender, String date) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		Idcard = idcard;
		this.phone = phone;
		this.gender = gender;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return Idcard;
	}
	public void setIdcard(String idcard) {
		Idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
