package vo;
/**
 * 20151022
 * 用户账号信息
 * @author 颜
 */
public class DepartmentVO {

	private String name;
	private String category;
	private String location;
	public DepartmentVO(String name, String category, String location) {
		super();
		this.name = name;
		this.category = category;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
