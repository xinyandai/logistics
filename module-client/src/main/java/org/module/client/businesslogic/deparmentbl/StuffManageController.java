package org.module.client.businesslogic.deparmentbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.department.CalculateSalaryService;
import org.module.client.businesslogicservice.department.StuffService;
import org.module.client.businesslogicservice.departmentBLservice.StuffManageBLService;
import org.module.client.vo.StuffVO;
import org.module.common.dataservice.MyList;

public class StuffManageController implements StuffManageBLService{

	private StuffService stuff ;
	private CalculateSalaryService salary; 
	private ArrayList<StuffVO> list;
	
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
			 stuffVO.setSlary(salary.calculateById(stuffVO.getIdentity(),""));
		 }
		 this.list =re;
		return re;
	}

	public boolean add(String name, String age, String category, String identity) {
		StuffVO vo = new StuffVO(name,age,category,identity);
		this.list.add(vo);
		return stuff.add(vo);
	}

	public boolean delete(String identity) {
		return stuff.delete(identity);
	}

	public boolean delete(MyList<String> ids) {
		return stuff.delete(ids);
	}

	public boolean update(String name, String age, String category,
			String identity) {
		for (StuffVO stuffVO : list) {
			if(stuffVO.getIdentity().equals(identity)){
				stuffVO.setAge(age);
				stuffVO.setCategory(category);
				stuffVO.setName(name);
			}
		}
		return stuff.modify(new StuffVO(name,age,category,identity));
	}

	public ArrayList<StuffVO> fuzzySearch(String s) {
		return stuff.fuzzySearch(s);
	}

	

	public boolean delete(int[] ins) {
		MyList<String> ids = new MyList<String>();
		for (int i = ins.length-1 ; i >=0; i--) {
			ids.add(this.list.get(i).getIdentity());
			this.list.remove(i);
			
		}
		return this.stuff.delete(ids);
	}

}
