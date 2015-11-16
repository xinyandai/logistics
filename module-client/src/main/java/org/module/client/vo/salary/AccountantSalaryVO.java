package org.module.client.vo.salary;

public class AccountantSalaryVO {
	/**
	 * 底薪
	 */
	private double base;  
	/**
	 * 收益提成
	 */
	private double bonus;
	public AccountantSalaryVO(double base, double bonus) {
		super();
		this.base = base;
		this.bonus = bonus;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
