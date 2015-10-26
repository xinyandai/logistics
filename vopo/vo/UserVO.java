package vo;

import vo.StuffVO;

public class UserVO {

	private int id;
	private String name;
	private String password;
	StuffVO  role;
	public UserVO(int id,String name,String password,StuffVO role) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.password=password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StuffVO getRole() {
		return role;
	}
	public void setRole(StuffVO role) {
		this.role = role;
	}
	

}
