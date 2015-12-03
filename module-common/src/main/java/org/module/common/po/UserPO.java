package org.module.common.po;

import java.io.Serializable;
/*
	 * 用户：00
	 * 营业厅快递员：01
	 * 营业厅业务员：02
	 * 中转中心业务员：11
	 * 中转中心仓库管理员：12
	 * 财务人员：31（不可以修改账户）
	 * 财务人员：32 （可以修改账户)
	 * 总经理：41
	 * 管理员: 51
	 */

public class UserPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2219996826045915600L;
	private String id;
	private String name;
	private String password;
	private String  role;
	private String departmeny;
	private String authority;
	
	final private String spt = ":%:%:";

	@Override
	public String toString(){
		return this.id + 
				this.spt +
				this.name + this.spt +
				this.password + this.spt +
				this.role + this.spt +
				this.departmeny + this.spt + 
				this.authority;
	}
	
	public UserPO(String string){
		
		String[] s = string.split(spt);
		this.id = s[0];
		this.name = s[1];
		this.password = s[2];
		this.role = s[3];
		this.departmeny = s[4];
		this.authority = s[5];
	}
	
	public UserPO(String id, String name, String password, String role,
			String departmeny, String authority) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.departmeny = departmeny;
		this.authority = authority;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getDepartmeny() {
		return departmeny;
	}

	public String getAuthority() {
		return authority;
	}
	
}

