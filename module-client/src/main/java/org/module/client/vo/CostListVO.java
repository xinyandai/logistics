package org.module.client.vo;

public class CostListVO {

	private String date;
	private double money;
	private String people;
	private String accout;
	private String entry;
	private String note;
	
	
	public CostListVO(String date, String money, String people, String accout,
			String entry, String note) {
		super();
		this.date = date;
		this.money = Double.parseDouble(money);
		this.people = people;
		this.accout = accout;
		this.entry = entry;
		this.note = note;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
