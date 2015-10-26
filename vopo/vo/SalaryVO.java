package vo;

public class SalaryVO {

	private String staff;
	private String money;
	public SalaryVO(String staff, String money) {
		super();
		this.staff = staff;
		this.money = money;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

}
