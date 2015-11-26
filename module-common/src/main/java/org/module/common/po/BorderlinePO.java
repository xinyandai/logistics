package org.module.common.po;

public class BorderlinePO {

	private String id;
	private String qu;
	private double line;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public double getLine() {
		return line;
	}
	public void setLine(double line) {
		this.line = line;
	}
	public BorderlinePO(String id, String qu, double line) {
		super();
		this.id = id;
		this.qu = qu;
		this.line = line;
	}
	
	final private String spt = ":%:%:";
	public BorderlinePO(String string) {
		super();
		String[] s = string.split(spt);
		this.id = s[0];
		this.qu = s[1];
		this.line = Double.parseDouble(s[2]);
	}
	@Override
	public String toString(){
		return this.id + this.spt + 
				this.qu + this.spt +
				this.line;
	}

}
