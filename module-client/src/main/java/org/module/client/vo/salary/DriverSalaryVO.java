package org.module.client.vo.salary;

public class DriverSalaryVO {
	/**
	 * 底薪
	 */
	private double base;  
	/**
	 * 每次市内运货提成
	 */
	private double bonusEveryIncityDriving;
	/**
	 * 跨市运货每千米提成
	 */
	private double bonusEveryKilometersOutcityDriving;
	
	
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getBonusEveryIncityDriving() {
		return bonusEveryIncityDriving;
	}
	public void setBonusEveryIncityDriving(double bonusEveryIncityDriving) {
		this.bonusEveryIncityDriving = bonusEveryIncityDriving;
	}
	public double getBonusEveryKilometersOutcityDriving() {
		return bonusEveryKilometersOutcityDriving;
	}
	public void setBonusEveryKilometersOutcityDriving(
			double bonusEveryKilometersOutcityDriving) {
		this.bonusEveryKilometersOutcityDriving = bonusEveryKilometersOutcityDriving;
	}
	public DriverSalaryVO(double base, double bonusEveryIncityDriving,
			double bonusEveryKilometersOutcityDriving) {
		super();
		this.base = base;
		this.bonusEveryIncityDriving = bonusEveryIncityDriving;
		this.bonusEveryKilometersOutcityDriving = bonusEveryKilometersOutcityDriving;
	}
}
