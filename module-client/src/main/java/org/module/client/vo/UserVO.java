package org.module.client.vo;


public class UserVO extends AbstractVO{

	private String id;
	private String name;
	private String password;
	private String  role;
	private String departmeny;
	private String authority;
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
	public String getDepartmeny() {
		return departmeny;
	}
	public void setDepartmeny(String departmeny) {
		this.departmeny = departmeny;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public UserVO(String id, String name, String password, String role,
			String departmeny, String authority) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.departmeny = departmeny;
		this.authority = authority;
	}
	public UserVO(String id, String password, String role) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
	}
	
	public String[] array(){
		String[] re = {this.id ,
		this.name ,
		this.password ,
		this.role,
		this.departmeny ,
		this.authority };
		return re;
	}
	
	
	@Override
	public String get(int i) {
		// TODO Auto-generated method stub
		return this.array()[i];
	}
	@Override
	public String[] names() {
		String[] s = {
				"ID","姓名","密码","类别","部门","权限"
		};
		return s;
	}
	
	
	
	
	

}
