package org.module.client.vo;

public class AccountVO {

	private String id;
	private double money;
	
	public AccountVO(String id, String rest) {
		super();
		this.id = id;
		this.money = Double.parseDouble(rest);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

}
