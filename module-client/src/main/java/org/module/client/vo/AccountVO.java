package org.module.client.vo;

public class AccountVO extends AbstractVO{

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
	
	public String[] array(){
		String[] s = {this.id,this.money+""};
		return s;
	}

	

	@Override
	public String get(int i) {
		return this.array()[i];
	}

}
