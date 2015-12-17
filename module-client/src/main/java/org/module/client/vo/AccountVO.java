package org.module.client.vo;

import org.module.common.po.AccountPO;

public class AccountVO extends AbstractVO{

	private String id;
	private double money;
	
	public AccountVO(String id, String rest) {
		super();
		this.id = id;
		this.money = Double.parseDouble(rest);
	}
	
	public AccountVO(AccountPO accountPO) {
		this(accountPO.getId(),accountPO.getMoney());
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

	@Override
	public String[] names() {
		String[] s = {
				"ID",
				"余额"
		};
		return s;
	}

}
