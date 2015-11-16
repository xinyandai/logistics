package org.module.common.po.salary;

public class OfficeClerkSalaryPO {

	/**
	 * 底薪
	 */
	private double base;  
	/**
	 * 派件提成
	 */
	private double bonusEveryDelivered;
	/**
	 * 收件提成
	 */
	private double bonusEveryReceive;
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getBonusEveryDelivered() {
		return bonusEveryDelivered;
	}
	public void setBonusEveryDelivered(double bonusEveryDelivered) {
		this.bonusEveryDelivered = bonusEveryDelivered;
	}
	public double getBonusEveryReceive() {
		return bonusEveryReceive;
	}
	public void setBonusEveryReceive(double bonusEveryReceive) {
		this.bonusEveryReceive = bonusEveryReceive;
	}
	public OfficeClerkSalaryPO(double base, double bonusEveryDelivered,
			double bonusEveryReceive) {
		super();
		this.base = base;
		this.bonusEveryDelivered = bonusEveryDelivered;
		this.bonusEveryReceive = bonusEveryReceive;
	}

}
