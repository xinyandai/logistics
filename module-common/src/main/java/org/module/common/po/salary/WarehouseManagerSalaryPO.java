package org.module.common.po.salary;

public class WarehouseManagerSalaryPO {
 
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
