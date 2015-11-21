package org.module.common.po.salary;

public class DriverSalaryPO {
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
	private String split=":%:%:";
	@Override
	public String toString(){
		return this.base+this.split+this.bonusEveryIncityDriving
				+this.split+this.bonusEveryKilometersOutcityDriving;
	}
	public DriverSalaryPO(double base, double bonusEveryIncityDriving,
			double bonusEveryKilometersOutcityDriving) {
		super();
		this.base = base;
		this.bonusEveryIncityDriving = bonusEveryIncityDriving;
		this.bonusEveryKilometersOutcityDriving = bonusEveryKilometersOutcityDriving;
	}
	public DriverSalaryPO(String str){
		super();
		String[] strs=str.split(this.split);
		this.base = Double.parseDouble(strs[0]);
		this.bonusEveryIncityDriving = Double.parseDouble(strs[1]);
		this.bonusEveryKilometersOutcityDriving = Double.parseDouble(strs[2]);
	}
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
	
}
