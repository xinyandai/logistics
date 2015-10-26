package vo;

public class AccountVO {

	private String id;
	private String money;
	public AccountVO(String id, String money) {
		super();
		this.id = id;
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

}
