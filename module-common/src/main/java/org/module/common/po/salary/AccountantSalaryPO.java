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
	private String split=":%:%:";
	
	@Override
	public String toString(){
		return this.base+this.split+this.bonus;
	}
	
	public AccountantSalaryPO(String str){
		super();
		String[] strs=str.split(this.split);
		this.base=Double.parseDouble(strs[0]);
		this.bonus=Double.parseDouble(strs[1]);
	}
	
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
