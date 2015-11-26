package org.module.client.BL.department;

import java.util.ArrayList;

import org.module.client.businesslogicservice.department.StuffService;
import org.module.client.vo.StuffVO;
import org.module.common.dataservice.MyList;

public class StuffMock implements StuffService {
	
	
	public ArrayList<StuffVO> showAll() {
		ArrayList<StuffVO> re = new ArrayList<StuffVO>();
		re.add(new StuffVO("name", "18", "快递员", "140010001"));
		return re;
	}

	public boolean add(StuffVO vo) {
		if(vo.getIdentity().equals("140010001")) return true;
		return true;
	}

	public boolean delete(String identity) {
		if(identity.equals("140010001")) return true;
		return false;
	}

	public boolean delete(MyList<String> ald) {
		return true;
	}

	public boolean modify(StuffVO vo) {
		if(vo.getIdentity().equals("140010001")) return true;
		return false;
	}

	public ArrayList<StuffVO> fuzzySearch(String s) {
		ArrayList<StuffVO> re = new ArrayList<StuffVO>();
		re.add(new StuffVO("name", "18", "快递员", "140010001"));
		return re;
	}

}
