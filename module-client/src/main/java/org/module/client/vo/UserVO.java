package org.module.client.vo;


public class UserVO {

	private String id;
	private String name;
	private String password;
	private String  role;
	private String authority;
	public UserVO(String id,String name,String password,String role,String authority) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.password=password;
		this.role = role;
		this.authority = authority;
	}
	public UserVO(String id,String password,String role) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = "";
		this.password=password;
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	

}
