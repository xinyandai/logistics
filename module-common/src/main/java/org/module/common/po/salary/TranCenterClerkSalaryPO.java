package org.module.common.po.salary;

import java.io.Serializable;

public class TranCenterClerkSalaryPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7501371483008855174L;
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
	
	
	
	private String split=":%:%:";
	
	
	@Override
	public String toString(){
		return this.base+this.split
				+this.bonusEveryArrival
				+this.split+this.bonusEveryLoading;
	}
	public TranCenterClerkSalaryPO(String str){
		super();
		String[] Strs=str.split(this.split);
		this.base = Double.parseDouble(Strs[0]);
		this.bonusEveryArrival = Double.parseDouble(Strs[1]);
		this.bonusEveryLoading = Double.parseDouble(Strs[2]);
	}
	public TranCenterClerkSalaryPO(double base, double bonusEveryArrival,
			double bonusEveryLoading) {
		super();
		this.base = base;
		this.bonusEveryArrival = bonusEveryArrival;
		this.bonusEveryLoading = bonusEveryLoading;
	}
	
	
	
	
	
	
	
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
	
	
}
