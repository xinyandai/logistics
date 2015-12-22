package org.module.common.po.salary;

import java.io.Serializable;

public class WarehouseManagerSalaryPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8252150772791797739L;
	/**
	 * 底薪
	 */
	private double base;  
	/**
	 * 每件入库提成
	 */
	private double bonusEveryGodownEntry;
	/**
	 * 出库提成
	 */
	private double bonusEveryOutBound;
	
	
	
	private String split=":%:%:";
	@Override
	public String toString(){
		return this.base+this.split
				+this.bonusEveryGodownEntry
				+this.split+this.bonusEveryOutBound;
	}
	public WarehouseManagerSalaryPO(String str){
		super();
		String[] strs=str.split(this.split);
		this.base = Double.parseDouble(strs[0]);
		this.bonusEveryGodownEntry =Double.parseDouble(strs[1]);
		this.bonusEveryOutBound = Double.parseDouble(strs[2]);
	}
	public WarehouseManagerSalaryPO(double base, double bonusEveryGodownEntry,
			double bonusEveryOutBound) {
		super();
		this.base = base;
		this.bonusEveryGodownEntry = bonusEveryGodownEntry;
		this.bonusEveryOutBound = bonusEveryOutBound;
	}
	
	
	
	

	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getBonusEveryGodownEntry() {
		return bonusEveryGodownEntry;
	}
	public void setBonusEveryGodownEntry(double bonusEveryGodownEntry) {
		this.bonusEveryGodownEntry = bonusEveryGodownEntry;
	}
	public double getBonusEveryOutBound() {
		return bonusEveryOutBound;
	}
	public void setBonusEveryOutBound(double bonusEveryOutBound) {
		this.bonusEveryOutBound = bonusEveryOutBound;
	}
}
