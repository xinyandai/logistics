package org.module.client.businesslogic.deparmentbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.department.DepartmentService;
import org.module.client.businesslogicservice.departmentBLservice.DepartmentManageBLService;
import org.module.client.vo.DepartmentVO;
import org.module.common.dataservice.MyList;

public class DepartmentManageController implements DepartmentManageBLService{
	
	private DepartmentService department ;
	private String[] type = {"营业厅","中转中心"};
	
	public DepartmentManageController(DepartmentService department) {
		super();
		this.department = department;
	}

	public DepartmentManageController() {
		this.department = new Department();
	}

	public ArrayList<DepartmentVO> showAll() {
		return department.showAll();
	}

	/**
	 * @see WarehouseInit
	 */
	public boolean add(String name, String category, String location,
			String identity) {
		DepartmentVO departmentVO = new DepartmentVO(name,category,location,identity);
		if(category.equals(type[1])){
			WarehouseInit initWarehouse = new WarehouseInit();
		    initWarehouse.add(identity);
		}
		return department.add(departmentVO);
	}

	public boolean delete(String identity) {
		return department.delete(identity);
	}

	public boolean delete(MyList<String> ids) {
		return department.delete(ids);
	}

	public boolean update(String name, String category, String location,
			String identity) {
		DepartmentVO departmentVO = new DepartmentVO(name,category,location,identity);
		return department.modify(departmentVO);
	}

	
	
	
	public ArrayList<String[]> toArrayList(){
		ArrayList<DepartmentVO> vo = this.showAll();
		ArrayList<String[]> re = new ArrayList<String[]>();
		for (int i = 0; i < vo.size(); i++) {
			re.add( vo.get(i).toArray());
		}
		return re;
	}
}
