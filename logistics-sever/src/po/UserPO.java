package po;

import java.io.Serializable;

public class UserPO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String password;
	String  role;
	/**
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
	private String authority;
	public UserPO(String id,String name,String password,String role,String authority) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.password=password;
		this.role = role;
		this.authority = authority;
	}
	public UserPO(String[] s){
		this(s[0],s[1],s[2],s[3],s[4]);
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
	public String toString(){
		return this.id+this.spt+this.name+this.spt+this.password+this.spt+this.role+this.spt+this.authority;
	}
	private String spt = ":%:%:";

}
