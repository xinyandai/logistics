package org.module.client.businesslogic.deparmentbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.department.CalculateSalaryService;
import org.module.client.businesslogicservice.department.StuffService;
import org.module.client.businesslogicservice.departmentBLservice.StuffManageBLService;
import org.module.client.vo.StuffVO;

public class StuffManageController implements StuffManageBLService{

	private StuffService stuff ;
	private CalculateSalaryService salary;  
	public StuffManageController() {
          stuff = new Stuff();
          salary = new CalculateSalary();
	}

	public StuffManageController(StuffService stuff,
			CalculateSalaryService salary) {
		super();
		this.stuff = stuff;
		this.salary = salary;
	}

	

	public ArrayList<StuffVO> showAll() {
		 ArrayList<StuffVO>  re = stuff.showAll();
		 for (StuffVO stuffVO : re) {
			 stuffVO.setSlary(salary.calculateById(stuffVO.getIdentity()));
		}
		return re;
	}

	public boolean add(String name, String age, String category, String identity) {
		// TODO Auto-generated method stub
		return stuff.add(new StuffVO(name,age,category,identity));
	}

	public boolean delete(String identity) {
		// TODO Auto-generated method stub
		return stuff.delete(identity);
	}

	public boolean delete(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		return stuff.delete(ids);
	}

	public boolean update(String name, String age, String category,
			String identity) {
		// TODO Auto-generated method stub
		return stuff.modify(new StuffVO(name,age,category,identity));
	}

	public ArrayList<StuffVO> fuzzySearch(String s) {
		// TODO Auto-generated method stub
		return stuff.fuzzySearch(s);
	}

}
