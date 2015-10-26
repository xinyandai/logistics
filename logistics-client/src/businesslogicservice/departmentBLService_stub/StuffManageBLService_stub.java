package businesslogicservice.departmentBLService_stub;

import java.util.ArrayList;

import vo.StuffVO;
import businesslogicservice.departmentBLservice.StuffManageBLService;

public class StuffManageBLService_stub implements StuffManageBLService{
	StuffVO svo;
	@Override
	public ArrayList<StuffVO> showAll() {
		// TODO 自动生成的方法存根
		System.out.println("show all stuff"); 
		return null;
	}

	@Override
	public boolean add(StuffVO d) {
		// TODO 自动生成的方法存根
		System.out.println("add successfully");
		return false;
	}

	@Override
	public boolean delete(StuffVO d) {
		// TODO 自动生成的方法存根
		if(d.getIdentity().length() == 9){
			this.svo = d;
			System.out.println("delete successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(ArrayList<StuffVO> ald) {
		// TODO 自动生成的方法存根
		//待修改方法
		return false;
	}

	@Override
	public boolean modify(StuffVO newone) {
		// TODO 自动生成的方法存根
		if(newone.getIdentity().equals("140010001")){
			System.out.println("can change");
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<StuffVO> fuzzySearch(String s) {
		// TODO 自动生成的方法存根
		//待修改
		return null;
	}
	
}
