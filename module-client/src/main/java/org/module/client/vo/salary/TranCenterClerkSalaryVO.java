package org.module.client.vo.salary;

public class TranCenterClerkSalaryVO {
	/**
	 * 底薪
	 */
	private double base;
	/*
	 * 每车到达接收提成
	 */
	private double bonusEveryArrival;
	/**
	 * 每车装车提成
	 */
	private double bonusEveryLoading;
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getBonusEveryArrival() {
		return bonusEveryArrival;
	}
	public void setBonusEveryArrival(double bonusEveryArrival) {
		this.bonusEveryArrival = bonusEveryArrival;
	}
	public double getBonusEveryLoading() {
		return bonusEveryLoading;
	}
	public void setBonusEveryLoading(double bonusEveryLoading) {
		this.bonusEveryLoading = bonusEveryLoading;
	}
	public TranCenterClerkSalaryVO(double base, double bonusEveryArrival,
			double bonusEveryLoading) {
		super();
		this.base = base;
		this.bonusEveryArrival = bonusEveryArrival;
		this.bonusEveryLoading = bonusEveryLoading;
	}
	
}
