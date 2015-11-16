package org.module.common.po.salary;

public class AccountantSalaryPO {
	/**
	 * 底薪
	 */
	private double base;  
	/**
	 * 收益提成
	 */
	private double bonus;
	public AccountantSalaryPO(double base, double bonus) {
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
