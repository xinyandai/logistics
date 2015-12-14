package org.module.client.businesslogic.deparmentbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.department.StuffService;
import org.module.client.vo.StuffVO;

public class StuffCount {
	private StuffService stuff ;
	private ArrayList<StuffVO> list;
	public StuffCount(){
		stuff = new Stuff();
		this.showAll();
	}
	
	public ArrayList<StuffVO> showAll() {
		 ArrayList<StuffVO>  re = stuff.showAll();
		 for (StuffVO stuffVO : re) {
			 stuffVO.setSlary(0);
		 }
		 this.list =re;
		return re;
	}
	
	
	public String[] getStuffArrayByDepartment(String deparment){
		return this.getIDWithName(this.limitStuffByDepartment(deparment));
	}
	
	public String[] getStuffByType(String type){
		return this.getIDWithName(this.limitStuffByType(type));
	}

	private ArrayList<StuffVO> limitStuffByDepartment(String id){
		ArrayList<StuffVO> re = new ArrayList<StuffVO>();
		for (StuffVO stuffVO : list) {
			if(stuffVO.getIdentity().substring(0, 6).equals(id)){
				re.add(stuffVO);
			}
		}
		return re;
	}
	
	private ArrayList<StuffVO> limitStuffByType(String type){
		ArrayList<StuffVO> re = new ArrayList<StuffVO>();
		for (StuffVO stuffVO : list) {
			if(stuffVO.getCategory().equals(type)){
				re.add(stuffVO);
			}
		}
		return re;
	}
	private String[] getIDWithName(ArrayList<StuffVO> vos){
		String[] re  = new String[vos.size()];
		for (int i= 0 ; i < vos.size(); i++){
			re[i] = vos.get(i).getIdentity()+vos.get(i).getName();
		}
		return re;
	}
}
