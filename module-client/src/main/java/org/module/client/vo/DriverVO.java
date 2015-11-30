package org.module.client.vo;

public class DriverVO {

	private String id;
	private String name;
	private String birthday;
	private String idcard;
	private String phone;
	private String gender;
	private String date;

	public DriverVO(String id, String name, String birthday, String idcard,
			String phone, String gender, String date) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.idcard = idcard;
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
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	public String[] toArray() {
		String[] re =new String[7];
		re[0] = id;
		re[1] = name;
		re[2] = birthday;
		re[3] = idcard;
		re[4] = phone;
		re[5] = gender;
		re[6] = date;
		return re;
	}

}
