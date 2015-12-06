/**
 * 
 */
package org.module.common.po;

import java.io.Serializable;

/**
 * @author 
 *
 */
public class WarehouseConfigPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8892203992452132754L;
	
	
	private String warehouseOfWhichTranCenter;
    private String[] qus;
    private String[] sizeOfQu;
	private String[] borderline;
    
   
	final private String spt = ":%:%:";
	final private String inlinespt = "&&&&&&&";
	/**
	 * 把订单号数组转化为字符串
	 * @param s
	 * @return
	 */
	private String getArrayToString(String[] s){
		String re = "";
		for (String string : s) {
			re += string + this.inlinespt;
		}
		return re;
	}
   
	@Override
	public String toString() {
		return 
				warehouseOfWhichTranCenter + this.spt+ 
				getArrayToString(qus) + this.spt +
				getArrayToString(sizeOfQu) + this.spt +
				this.getArrayToString(borderline);
	}
    
    public WarehouseConfigPO(String string) {
		super();
		String[] s = string.split(this.spt);
		this.warehouseOfWhichTranCenter = s[0];
		this.qus = s[1].split(inlinespt);
		this.sizeOfQu = s[2].split(this.inlinespt);
		this.borderline = s[3].split(this.inlinespt);
	}
    public WarehouseConfigPO(String warehouseOfWhichTranCenter, String[] qus,
			String[] sizeOfQu, String[] borderline) {
		super();
		this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
		this.qus = qus;
		this.sizeOfQu = sizeOfQu;
		this.borderline = borderline;
	}
	
    public String[] getBorderline() {
		return borderline;
	}
	public String getWarehouseOfWhichTranCenter() {
		return warehouseOfWhichTranCenter;
	}
	public String[] getQus() {
		return qus;
	}
	public String[] getSizeOfQu() {
		return sizeOfQu;
	}
	
}
